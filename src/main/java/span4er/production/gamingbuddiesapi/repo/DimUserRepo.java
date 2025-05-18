package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.model.DimUser;

import java.util.Optional;

@Repository
public interface DimUserRepo extends JpaRepository<DimUser, String>, JpaSpecificationExecutor<DimUser>  {
    Optional<DimUser> findByUsername(String login);
}
