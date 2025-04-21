package span4er.production.gamingbuddiesapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "dimuser")
public class DimUser {
    @Id
    @UuidGenerator
    @Column(name = "userid", unique = true, updatable = false)
    private String userid;
    @NonNull
    private String userlogin;
    @NonNull
    private String username;
    @NonNull
    private Integer usertypeid;
    private String userpassword;
    private String userpicname;
    private String userbio;
}
