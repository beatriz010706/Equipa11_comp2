package lp.Equipa11_comp2.Mapper;
/**
 * @author beatriz silva
 */
import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.DTO.UtilizadorDTO;

// Mapper = classe que converte a entidade para DTO e vice-versa
// Muito útil para não expor passwords ou dados sensíveis
@Component
public class UtilizadorMapper {

    // Converte de Entity para DTO
    public UtilizadorDTO toDTO(Utilizador u) {
        UtilizadorDTO dto = new UtilizadorDTO();
        dto.setId(u.getIdUtilizador());
        dto.setNome(u.getNome());
        dto.setIdade(u.getIdade());
        dto.setEmail(u.getEmail());
        return dto;
    }

    // Converte de DTO para Entity
    public Utilizador toEntity(UtilizadorDTO dto) {
        Utilizador u = new Utilizador();
        u.setNome(dto.getNome());
        u.setIdade(dto.getIdade());
        u.setEmail(dto.getEmail());
        return u;
    }
}
