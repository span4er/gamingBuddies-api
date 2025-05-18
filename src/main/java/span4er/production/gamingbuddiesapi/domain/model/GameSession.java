package span4er.production.gamingbuddiesapi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "gamesession")
public class GameSession {
    @Id
    @SequenceGenerator(name = "gamesession_gamesessionid",
            sequenceName = "gamesession_gamesessionid",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamesession_gamesessionid")
    @Column(name = "gamesessionid", unique = true, updatable = false)
    private Long gamesessionid;
    @ManyToOne
    @JoinColumn(name="gameid", referencedColumnName = "gameid")
    private DimGame game;
    @ManyToOne
    @JoinColumn(name="platformid", referencedColumnName = "platformid")
    private DimGamingPlatform platform;
    @ManyToOne
    @JoinColumn(name="createuserid", referencedColumnName = "userid")
    private DimUser createuser;
    private LocalDateTime createdttm;
    private LocalDateTime startdttm;
    private LocalDateTime enddttm;
    @ManyToOne
    @JoinColumn(name="sessionstatusid", referencedColumnName = "sessionstatusid")
    private DimGameSessionStatus sessionstatus;
    private Integer capacitynum;
    @ManyToOne
    @JoinColumn(name="categoryid", referencedColumnName = "categoryid")
    private DimSessionCategory category;
    @ManyToOne
    @JoinColumn(name="languageid", referencedColumnName = "languageid")
    private DimSessionLanguages language;
    @Column(length = 2000)
    private String sessiondescription;
    private Boolean isnotificationssent;
    @Column(length = 500)
    private String name;
    // Добавляем новую связь с сущностью MapUser2GameSession
    @OneToMany(mappedBy = "gameSession")
    private Set<MapUser2GameSession> usersInSession;
}
