package lp.Equipa11_comp2.Repository;
/**
 * @author beatriz silva
 */
import org.springframework.data.jpa.repository.JpaRepository;
import lp.Equipa11_comp2.Entity.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // Podemos adicionar métodos customizados se necessário
}
