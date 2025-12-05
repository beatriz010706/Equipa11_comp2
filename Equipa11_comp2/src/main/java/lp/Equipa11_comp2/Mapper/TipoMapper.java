package lp.Equipa11_comp2.Mapper;
/**
 * @author diogo garcia 
 */
import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.TipoDTO;
import lp.Equipa11_comp2.Entity.Tipo;

@Component
public class TipoMapper {

    public TipoDTO toDTO(Tipo t) {
        return new TipoDTO(t.getIdTipo(), t.getDescricaoTipo());
    }

    public Tipo toEntity(TipoDTO dto) {
        return new Tipo(dto.getDescricaoTipo());
    }
}//fim classe
