package span4er.production.gamingbuddiesapi.repo.projections;

import java.time.LocalDateTime;

public interface NotificationsInfoForSearch {
    Long getNotificationId();
    Long getTargetUserId();
    String getNotificationTypeName();
    Boolean getIsNotificationRead();
    LocalDateTime getCreateDttm();
    LocalDateTime getReadDttm();
    String getNotificationDescription();
}
