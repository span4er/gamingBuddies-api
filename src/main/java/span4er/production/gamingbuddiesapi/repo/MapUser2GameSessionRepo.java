package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import span4er.production.gamingbuddiesapi.domain.model.MapUser2GameSession;

public interface MapUser2GameSessionRepo extends JpaRepository<MapUser2GameSession, String>, JpaSpecificationExecutor<MapUser2GameSession> {
}
