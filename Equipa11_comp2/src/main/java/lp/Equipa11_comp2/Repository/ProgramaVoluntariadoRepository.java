package lp.Equipa11_comp2.Repository;

/**
 * @author miguel silva
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;

@Repository
public interface ProgramaVoluntariadoRepository extends JpaRepository<ProgramaVoluntariado, Long> {
	
}//fim classe
