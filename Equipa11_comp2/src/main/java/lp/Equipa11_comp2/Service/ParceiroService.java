package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.DTO.ParceiroDTO;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Mapper.ParceiroMapper;
import lp.Equipa11_comp2.Repository.ParceiroRepository;
import lp.Equipa11_comp2.Repository.ProgramaVoluntariadoRepository;

@Service
public class ParceiroService {

    @Autowired
    private ParceiroRepository repo;

    @Autowired
    private ParceiroMapper mapper;
    
    @Autowired
    private ProgramaVoluntariadoRepository programaRepo;

    @Autowired
    private ParceiroRepository parceiroRepo;

    // Registar parceiro
    public ParceiroDTO registar(ParceiroDTO dto) {
        Parceiro p = mapper.toEntity(dto);
        repo.save(p);
        return mapper.toDTO(p);
    }

    // Login
    public ParceiroDTO login(String email, String password) {
        Parceiro p = repo.findByEmail(email);
        if (p != null && p.getPassword().equals(password)) {
            return mapper.toDTO(p);
        }
        return null;
    }

    // Buscar parceiro por ID
    public Parceiro findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Métodos de programas
    public void registarPrograma(Parceiro p, ProgramaVoluntariado prog) {
        p.registarPrograma(prog);
        repo.save(p);
    }

    public void editarPrograma(Parceiro p, ProgramaVoluntariado prog, String titulo, int horas) {
        p.editarPrograma(prog, titulo, horas);
        repo.save(p);
    }

    public void eliminarPrograma(Parceiro p, ProgramaVoluntariado prog) {
        // procurar programa pelo ID enviado
        ProgramaVoluntariado programa = programaRepo.findById(prog.getId())
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        if (p.getProgramasVoluntariado() != null) {
            p.getProgramasVoluntariado().remove(programa);
        }
        programaRepo.delete(programa);

    }
}//fim classe

