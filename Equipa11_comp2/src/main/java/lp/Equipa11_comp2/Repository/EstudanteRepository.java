package lp.Equipa11_comp2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.*;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    Estudante findByEmail(String email);
}

