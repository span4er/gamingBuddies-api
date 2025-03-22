package span4er.production.gamingbuddiesapi.repo;

import com.fasterxml.jackson.databind.JsonSerializable;
import span4er.production.gamingbuddiesapi.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String>, JpaSpecificationExecutor<Contact> {
    Optional<Contact> findById(String id);
}