package span4er.production.gamingbuddiesapi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dimusertype")
public class DimUserType {
    @Id
    @Column(name = "usertypeid", unique = true, updatable = false)
    private Integer usertypeId;
    @Column(name = "name", length = 254)
    private String name;
    @Column(name = "ismoderator")
    private Boolean isModerator;
    @Column(name = "isadmin")
    private Boolean isAdmin;
}
