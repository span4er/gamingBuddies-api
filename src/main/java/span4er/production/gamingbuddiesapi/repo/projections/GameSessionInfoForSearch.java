package span4er.production.gamingbuddiesapi.repo.projections;

import java.time.LocalDateTime;

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
