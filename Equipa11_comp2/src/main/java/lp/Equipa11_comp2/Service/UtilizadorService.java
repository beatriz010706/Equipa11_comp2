package lp.Equipa11_comp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.DTO.UtilizadorDTO;
import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.Mapper.UtilizadorMapper;
import lp.Equipa11_comp2.Repository.CandidaturaRepository;
import lp.Equipa11_comp2.Repository.UtilizadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizadorService {

    @Autowired
    private UtilizadorRepository repo;

    @Autowired
    private CandidaturaRepository candidaturaRepo;

    @Autowired
    private UtilizadorMapper mapper;

    // -----------------------------
    // REGISTAR
    // -----------------------------
    public Utilizador registar(UtilizadorDTO dto) {
        Utilizador u = mapper.toEntity(dto);
        return repo.save(u);
    }

    // -----------------------------
    // LOGIN
    // -----------------------------
    public Utilizador login(String email, String password) {
        Optional<Utilizador> user = repo.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    // -----------------------------
    // HISTÓRICO DE CANDIDATURAS
    // -----------------------------
    public List<Candidatura> consultarHistoricoCandidaturas(Long idUtilizador) {
        return candidaturaRepo.findByEstudante_IdUtilizador(idUtilizador);
    }
}
