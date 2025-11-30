package lp.Equipa11_comp2.Mapper;

import org.springframework.stereotype.Component;

import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.DTO.UtilizadorDTO;

@Component
public class UtilizadorMapper {

    public Utilizador toEntity(UtilizadorDTO dto) {
        return new Utilizador(
                dto.getNome(),
                dto.getEmail(),
                dto.getPassword()
        );
    }
}
