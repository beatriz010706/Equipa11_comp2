package lp.Equipa11_comp2.Repository;
/**
 * @author beatriz silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.Utilizador;
import java.util.Optional;

//Repository = interface que permite aceder à base de dados
//JpaRepository já tem métodos prontos como save(), findById(), delete(), findAll()
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

	// Procura por email — útil para login e registo
    Optional<Utilizador> findByEmail(String email);
}//fim classe

