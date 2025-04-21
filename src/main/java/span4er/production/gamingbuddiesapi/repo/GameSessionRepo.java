package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.GameSession;

import java.util.Optional;

@Repository
public interface GameSessionRepo extends JpaRepository<GameSession, String>, JpaSpecificationExecutor<GameSession> {
    Optional<GameSession> findByGamesessionid(Long id);
}
