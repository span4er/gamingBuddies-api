package span4er.production.gamingbuddiesapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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
    @SequenceGenerator(name = "dimuser_userid",
            sequenceName = "dimuser_userid",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dimuser_userid")
    @Column(name = "userid", unique = true, updatable = false)
    private String userid;
    @NonNull
    private String userlogin;
    @NonNull
    private String username;
    @NonNull
    private Integer usertypeid;
    @Column(length = 500)
    private String userpassword;
    private String userpicname;
    @Column(length = 6000)
    private String userbio;
}
