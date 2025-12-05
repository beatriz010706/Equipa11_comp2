package lp.Equipa11_comp2.Repository;
/**
 * @author gonçalo silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.Candidatura;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    // Buscar candidaturas de um estudante usando o id do utilizador
    List<Candidatura> findByEstudante_IdUtilizador(Long idUtilizador);

    // Buscar candidaturas associadas a um programa de voluntariado
    List<Candidatura> findByProgramaVoluntariado_Id(Long programaId);
}//fim classe
