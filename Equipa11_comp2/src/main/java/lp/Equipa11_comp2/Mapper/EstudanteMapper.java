package lp.Equipa11_comp2.Mapper;
/**
 * @author beatriz silva
 */
import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Entity.*;

@Component
public class EstudanteMapper {

    public EstudanteDTO toDTO(Estudante e) {
        if (e == null) return null;

        int totalCandidaturas = (e.getCandidaturas() != null) ? e.getCandidaturas().size() : 0;
        int programasConcluidos = (e.getProgramasEstudante() != null) ? e.getProgramasEstudante().size() : 0;

        return new EstudanteDTO(
                e.getIdUtilizador(),
                e.getNome(),
                e.getEmail(),
                e.getPassword(),
                e.getCurso(),
                e.getNumeroAluno(),
                totalCandidaturas,
                programasConcluidos
        );
    }

    public Estudante toEntity(EstudanteDTO dto) {
        if (dto == null) return null;

        Estudante e = new Estudante();
        e.setNome(dto.getNome());
        e.setEmail(dto.getEmail());
        e.setPassword(dto.getPassword());
        e.setCurso(dto.getCurso());
        e.setNumeroAluno(dto.getNumeroAluno());
        return e;
    }
}
