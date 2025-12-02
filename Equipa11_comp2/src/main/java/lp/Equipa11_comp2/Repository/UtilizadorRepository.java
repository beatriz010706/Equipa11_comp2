package lp.Equipa11_comp2.Repository;
/**
 * @author beatriz silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.Utilizador;

import java.util.Optional;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
    Optional<Utilizador> findByEmail(String email);
}//fim classe


