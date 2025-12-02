package lp.Equipa11_comp2.Repository;
/**
 * @author diogo garcia 
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lp.Equipa11_comp2.Entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
