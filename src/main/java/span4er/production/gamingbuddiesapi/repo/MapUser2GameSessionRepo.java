package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.domain.MapUser2GameSession;

import java.util.List;
import java.util.Optional;

public interface MapUser2GameSessionRepo extends JpaRepository<MapUser2GameSession, String>, JpaSpecificationExecutor<MapUser2GameSession> {
}
