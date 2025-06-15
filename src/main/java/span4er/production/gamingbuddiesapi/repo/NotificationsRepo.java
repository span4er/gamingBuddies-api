package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import span4er.production.gamingbuddiesapi.domain.model.Notifications;
import span4er.production.gamingbuddiesapi.repo.projections.NotificationsInfoForSearch;

public interface NotificationsRepo extends JpaRepository<Notifications, Long>, JpaSpecificationExecutor<Notifications> {
    @Query("select \n" +
            "np.notificationId as notificationId,\n" +
            "np.targetUser.userid as targetUserId,\n" +
            "np.notificationType.typeSysName as notificationTypeName,\n" +
            "np.isNotificationRead as isNotificationRead,\n" +
            "np.createDttm as createDttm,\n" +
            "np.readDttm as readDttm,\n" +
            "np.description as notificationDescription\n"+
            "from Notifications np\n" +
            "WHERE np.targetUser.userid = :targetUserId\n" +
            "ORDER BY np.createDttm DESC")
    Page<NotificationsInfoForSearch> findNotificationsByTargetUserUseridEquals(Pageable pageable, Long targetUserId);
}
