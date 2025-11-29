package lp.Equipa11_comp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.Tipo;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Repository.TipoRepository;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository repo;

    // Salvar ou atualizar Tipo
    public Tipo salvarTipo(Tipo t) {
        return repo.save(t);
    }

    // Listar todos
    public List<Tipo> listarTipos() {
        return repo.findAll();
    }

    // Adicionar Parceiro a um Tipo
    public void adicionarParceiro(Tipo t, Parceiro p) {
        t.adicionarParceiro(p);
        repo.save(t);
    }

    // Remover Parceiro de um Tipo
    public void removerParceiro(Tipo t, Parceiro p) {
        t.removerParceiro(p);
        repo.save(t);
    }

    // Adicionar ProgramaVoluntariado a um Tipo
    public void adicionarPrograma(Tipo t, ProgramaVoluntariado p) {
        t.adicionarProgramaVoluntariado(p);
        repo.save(t);
    }

    // Remover ProgramaVoluntariado de um Tipo
    public void removerPrograma(Tipo t, ProgramaVoluntariado p) {
        t.removerProgramaVoluntariado(p);
        repo.save(t);
    }
}
