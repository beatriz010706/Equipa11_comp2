package lp.Equipa11_comp2.Mapper;
/**
 * @author beatriz silva
 */
import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.DTO.ParceiroDTO;

/**
 * Mapper para converter Parceiro <-> DTO
 */
@Component
public class ParceiroMapper {

    // DTO -> Entity
    public Parceiro toEntity(ParceiroDTO dto, Tipo tipo) {
        Parceiro p = new Parceiro();
        p.setNome(dto.getNome());
        p.setIdade(dto.getIdade());
        p.setEmail(dto.getEmail());
        p.setLocal(dto.getLocal());
        p.setTipo(tipo);
        return p;
    }

    // Entity -> DTO
    public ParceiroDTO toDTO(Parceiro p) {
        ParceiroDTO dto = new ParceiroDTO();
        dto.setId(p.getIdUtilizador());
        dto.setNome(p.getNome());
        dto.setIdade(p.getIdade());
        dto.setEmail(p.getEmail());
        dto.setLocal(p.getLocal());
        if (p.getTipo() != null)
            dto.setIdTipo(p.getTipo().getIdTipo());
        return dto;
    }
}//fim classe