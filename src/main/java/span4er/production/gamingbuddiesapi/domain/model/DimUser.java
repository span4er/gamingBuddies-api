package span4er.production.gamingbuddiesapi.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "dimuser")
public class DimUser implements UserDetails {
    @Id
    @SequenceGenerator(name = "dimuser_userid",
            sequenceName = "dimuser_userid",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dimuser_userid")
    @Column(name = "userid", unique = true, updatable = false)
    private Long userid;
    @NonNull
    @Column(name="userlogin",length = 255)
    private String username;
    @NonNull
    @Column(name="username",length = 255)
    private String userFIO;
    @OneToOne
    @JoinColumn(name="usertypeid", referencedColumnName = "usertypeid")
    private DimUserType usertypeId;
    @Column(name="userpassword",length = 500)
    private String password;
    private String userpicname;
    @Column(length = 6000)
    private String userbio;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(usertypeId.getName()));
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
