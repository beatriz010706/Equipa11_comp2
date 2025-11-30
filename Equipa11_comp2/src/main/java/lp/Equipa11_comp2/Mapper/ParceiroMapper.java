package lp.Equipa11_comp2.Mapper;

import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.DTO.ParceiroDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParceiroMapper {

    public ParceiroDTO toDTO(Parceiro p) {
        if (p == null) return null;

        List<String> titulos = new ArrayList<>();
        if (p.getProgramasVoluntariado() != null) {
            for (var prog : p.getProgramasVoluntariado()) {
                titulos.add(prog.getTitulo());
            }
        }

        return new ParceiroDTO(
                p.getIdUtilizador(),
                p.getNome(),
                p.getEmail(),
                p.getPassword(),
                p.getLocal(),
                titulos
        );
    }

    public Parceiro toEntity(ParceiroDTO dto) {
        if (dto == null) return null;

        Parceiro p = new Parceiro();
        p.setNome(dto.getNome());
        p.setEmail(dto.getEmail());
        p.setPassword(dto.getPassword());
        p.setLocal(dto.getLocal());
        return p;
    }
}

