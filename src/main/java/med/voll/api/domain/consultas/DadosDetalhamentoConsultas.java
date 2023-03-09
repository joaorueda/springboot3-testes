package med.voll.api.domain.consultas;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosDetalhamentoConsultas(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsultas(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
