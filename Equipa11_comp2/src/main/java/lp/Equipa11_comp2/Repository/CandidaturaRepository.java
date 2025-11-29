package lp.Equipa11_comp2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import lp.Equipa11_comp2.Entity.*;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
	List<Candidatura> findByEstudante(Estudante estudante);

}//fim classe
