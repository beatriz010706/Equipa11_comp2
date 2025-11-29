package lp.Equipa11_comp2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lp.Equipa11_comp2.Entity.ProgramaEstudante;

@Repository
public interface ProgramaEstudanteRepository extends JpaRepository<ProgramaEstudante, Long> {
}
