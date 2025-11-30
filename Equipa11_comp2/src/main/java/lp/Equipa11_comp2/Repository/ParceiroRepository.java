package lp.Equipa11_comp2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.Parceiro;

public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {
    Parceiro findByEmail(String email);
}

