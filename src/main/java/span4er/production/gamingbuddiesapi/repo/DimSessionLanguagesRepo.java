package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.model.DimSessionLanguages;

@Repository
public interface DimSessionLanguagesRepo extends JpaRepository<DimSessionLanguages, Integer>, JpaSpecificationExecutor<DimSessionLanguages> {
}
