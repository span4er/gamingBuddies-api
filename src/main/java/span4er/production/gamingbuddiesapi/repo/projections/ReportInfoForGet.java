package span4er.production.gamingbuddiesapi.repo.projections;

import java.time.LocalDateTime;

public interface ReportInfoForGet {
    String getReportDescription();
    String getReportedUserPicName();
    String getReportedUserName();
    String getCreatedUserPicName();
    String getCreatedUserName();
    String getReportReasonName();
    LocalDateTime getCreateDttm();
    String getReportStatusName();
}
