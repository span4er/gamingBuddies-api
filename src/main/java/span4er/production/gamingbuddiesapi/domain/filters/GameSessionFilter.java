package span4er.production.gamingbuddiesapi.domain.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameSessionFilter {
    String createuserid;
    String gameid;
}
