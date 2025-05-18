package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.model.DimUserType;

import java.util.Optional;

@Repository
public interface DimUserTypeRepo extends JpaRepository<DimUserType, Integer>, JpaSpecificationExecutor<DimUserType> {
    Optional<DimUserType> findByUsertypeId(Integer usertypeId);
}
