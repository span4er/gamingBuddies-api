package span4er.production.gamingbuddiesapi.repo.projections;

import java.time.LocalDateTime;

public interface ReportsInfoForSearch {
    Long getReportId();
    String getReportedUserId();
    String getReportedUserPicName();
    String getReportedUserName();
    String getCreatedUserId();
    String getCreatedUserPicName();
    String getCreatedUserName();
    String getReportReasonName();
    LocalDateTime getCreateDttm();
    String getReportStatusName();
    String getReportDescription();
}
