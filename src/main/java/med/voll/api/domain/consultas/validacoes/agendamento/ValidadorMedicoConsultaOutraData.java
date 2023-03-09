package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoConsultaOutraData implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoHorario){
            throw new ValidacaoException("Medico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
