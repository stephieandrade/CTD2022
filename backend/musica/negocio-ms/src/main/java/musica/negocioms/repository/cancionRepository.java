package musica.negocioms.repository;

import musica.negocioms.model.cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cancionRepository extends JpaRepository<cancion, Integer> {
}
