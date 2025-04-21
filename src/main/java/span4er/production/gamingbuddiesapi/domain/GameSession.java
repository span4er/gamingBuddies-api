package span4er.production.gamingbuddiesapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @Column(name = "gamesessionid", unique = true, updatable = false)
    private Long gamesessionid;
    private Long gameid;
    private Long platformid;
    private String createuserid;
    private LocalDateTime createdttm;
    private LocalDateTime startdttm;
    private LocalDateTime enddttm;
    private Integer sessionstatusid;
    private Integer capacitynum;
    private Integer categoryid;
    private Integer languageid;
    @Column(length = 2000)
    private String sessiondescription;
    private Boolean isnotificationssent;
    @Column(length = 500)
    private String name;
}
