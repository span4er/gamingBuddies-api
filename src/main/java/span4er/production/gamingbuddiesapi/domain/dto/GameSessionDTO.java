package span4er.production.gamingbuddiesapi.domain.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import span4er.production.gamingbuddiesapi.domain.*;

import java.time.LocalDateTime;
import java.util.Set;

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
