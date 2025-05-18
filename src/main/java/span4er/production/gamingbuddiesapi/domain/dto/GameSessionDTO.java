package span4er.production.gamingbuddiesapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class GameSessionDTO {
    private Long gameid;
    private Integer platformid;
    private String createuserid;
    private LocalDateTime startdttm;
    private LocalDateTime enddttm;
    private Integer sessionstatusid;
    private Integer capacitynum;
    private Integer categoryid;
    private Integer languageid;
    private String sessiondescription;
    private String name;
}
