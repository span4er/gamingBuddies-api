package span4er.production.gamingbuddiesapi.repo.projections;

import java.time.LocalDateTime;

public interface GameSessionInfoForGet {
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
    String getGamingPlatform();
}
