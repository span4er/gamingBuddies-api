package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.DimGame;
import span4er.production.gamingbuddiesapi.domain.DimGamingPlatform;

@Repository
public interface DimGamingPlatformRepo extends JpaRepository<DimGamingPlatform, Integer>, JpaSpecificationExecutor<DimGamingPlatform> {
}
