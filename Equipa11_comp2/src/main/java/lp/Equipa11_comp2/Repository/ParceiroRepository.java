package lp.Equipa11_comp2.Repository;
/**
 * @author beatriz silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.*;

/**
 * Repositório do Parceiro
 * Permite CRUD básico
 */
public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {
	
}//fim classe
