package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.DimGame;

import java.util.Optional;

@Repository
public interface DimGameRepo extends JpaRepository<DimGame, String>, JpaSpecificationExecutor<DimGame> {
    Optional<DimGame> findDimGameByGameid(Long id);
}
