package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import span4er.production.gamingbuddiesapi.domain.model.Reports;
import span4er.production.gamingbuddiesapi.repo.projections.ReportInfoForGet;
import span4er.production.gamingbuddiesapi.repo.projections.ReportsInfoForSearch;

import java.util.Optional;

public interface ReportsRepo extends JpaRepository<Reports, Long>, JpaSpecificationExecutor<Reports> {
    @Query("select \n" +
            "rp.reportId as reportId,\n" +
            "rp.reportedUserId.userid as reportedUserId,\n" +
            "rp.reportedUserId.userpicname as reportedUserPicName,\n" +
            "rp.reportedUserId.userFIO as reportedUserName,\n" +
            "rp.createdUserId.userid as createdUserId,\n" +
            "rp.createdUserId.userpicname as createdUserPicName,\n" +
            "rp.createdUserId.userFIO as createdUserName,\n" +
            "rp.reportReasonId.name as reportReasonName,\n" +
            "rp.createDttm as createDttm,\n" +
            "rp.reportStatusId.name as reportStatusName,\n" +
            "rp.description as reportDescription\n"+
            "from Reports rp")
    Page<ReportsInfoForSearch> findAllProjection(Pageable pageable);

    @Query("select \n" +
            "rp.reportId as reportId,\n" +
            "rp.reportedUserId.userpicname as reportedUserPicName,\n" +
            "rp.reportedUserId.username as reportedUserName,\n" +
            "rp.createdUserId.userpicname as createdUserPicName,\n" +
            "rp.createdUserId.username as createdUserName,\n" +
            "rp.reportReasonId.name as reportReasonName,\n" +
            "rp.createDttm as createDttm,\n" +
            "rp.reportStatusId.name as reportStatusName,\n" +
            "rp.description as reportDescription\n"+
            "from Reports rp")
    Optional<ReportInfoForGet> findByReportId(Long reportId);
}
