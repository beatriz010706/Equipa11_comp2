package lp.Equipa11_comp2.Mapper;
/**
 * @author beatriz silva
 */
import org.springframework.stereotype.Component;

import lp.Equipa11_comp2.Entity.Estudante;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.DTO.UtilizadorDTO;

// Mapper = classe que converte a entidade para DTO e vice-versa
// Muito útil para não expor passwords ou dados sensíveis

@Component
public class UtilizadorMapper {

	// Converte DTO para Entity (Estudante ou Parceiro)
    public Utilizador toEntity(UtilizadorDTO dto) {
        Utilizador u;

        if("Estudante".equalsIgnoreCase(dto.getTipo())) {
            u = new Estudante();
        } else if("Parceiro".equalsIgnoreCase(dto.getTipo())) {
            u = new Parceiro();
        } else {
            u = new Utilizador();
        }

        u.setNome(dto.getNome());
        u.setIdade(dto.getIdade());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());

        return u;
    }

    // Converte Entity → DTO
    public UtilizadorDTO toDTO(Utilizador u) {
        UtilizadorDTO dto = new UtilizadorDTO();
        dto.setId(u.getIdUtilizador());
        dto.setNome(u.getNome());
        dto.setIdade(u.getIdade());
        dto.setEmail(u.getEmail());

        if(u instanceof Estudante) {
            dto.setTipo("Estudante");
        } else if(u instanceof Parceiro) {
            dto.setTipo("Parceiro");
        } else {
            dto.setTipo("Utilizador");
        }

        return dto;
    }
}
