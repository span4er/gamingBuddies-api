package span4er.production.gamingbuddiesapi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "notifications")
public class Notifications {
    @Id
    @SequenceGenerator(name = "notifications_notificationid",
            sequenceName = "notifications_notificationid",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifications_notificationid")
    @Column(name = "notificationid", unique = true, updatable = false)
    private Long notificationId;
    @ManyToOne
    @JoinColumn(name="targetuserid", referencedColumnName = "userid")
    private DimUser targetUser;
    @ManyToOne
    @JoinColumn(name="notificationtypeid", referencedColumnName = "notificationtypeid")
    private DimNotificationType notificationType;
    @Column(name = "isnotificationread")
    private Boolean isNotificationRead;
    @Column(name = "createdttm")
    private LocalDateTime createDttm;
    @Column(name = "readdttm")
    private LocalDateTime readDttm;
    @Column(length = 2000)
    private String description;
}
