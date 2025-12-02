package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Mapper.*;
import lp.Equipa11_comp2.Repository.*;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repo;

    @Autowired
    private EstudanteMapper mapper;

    // Registar estudante
    public EstudanteDTO registar(EstudanteDTO dto) {
        Estudante e = mapper.toEntity(dto);
        repo.save(e);
        return mapper.toDTO(e);
    }

    // Login
    public EstudanteDTO login(String email, String password) {
        Estudante e = repo.findByEmail(email);
        if (e != null && e.getPassword().equals(password)) {
            return mapper.toDTO(e);
        }
        return null;
    }

    // Histórico de candidaturas
    public String consultarHistorico(Long idEstudante) {
        Estudante e = repo.findById(idEstudante).orElse(null);
        if (e == null) return "Estudante não encontrado.";

        List<Candidatura> lista = e.getCandidaturas();
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico de Candidaturas:\n");

        for (Candidatura c : lista) {
            sb.append(" Programa: ")
              .append(c.getProgramaVoluntariado().getTitulo())
              .append(" | Estado: ")
              .append(c.getEstado() != null ? c.getEstado().name() : "Em andamento")
              .append("\n");
        }

        return sb.toString();
    }

}//fim classe
