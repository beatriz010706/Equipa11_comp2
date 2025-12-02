package lp.Equipa11_comp2.Repository;
/**
 * @author beatriz silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.*;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    Estudante findByEmail(String email);
}

