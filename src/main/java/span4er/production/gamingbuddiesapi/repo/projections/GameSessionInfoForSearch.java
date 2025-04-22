package span4er.production.gamingbuddiesapi.repo.projections;

import span4er.production.gamingbuddiesapi.domain.DimGame;

import java.time.LocalDateTime;
import java.util.List;

public interface GameSessionInfoForSearch {
    Long getGameSessionId();
    String getSessionDescription();
    String getSessionName();
    String getCreateUserLogin();
    String getCreateUserPicName();
    LocalDateTime getCreateDttm();
    LocalDateTime getStartDttm();
    LocalDateTime getEndDttm();
    Integer getCapacityNum();
    String getCategoryName();
    Long getGameId();
    String getGamePicName();
    String getLanguageShort();
    Integer getSessionStatusId();
    String getSessionStatusName();
    String getGamingPlatform();
}
