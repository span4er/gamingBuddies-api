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
@Table(name = "reports")
public class Reports {
    @Id
    @SequenceGenerator(name = "reports_reportid",
            sequenceName = "reports_reportid",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reports_reportid")
    @Column(name = "reportid", unique = true, updatable = false)
    private Long reportId;
    @ManyToOne
    @JoinColumn(name="reporteduserid", referencedColumnName = "userid")
    private DimUser reportedUserId;
    @ManyToOne
    @JoinColumn(name="createuserid", referencedColumnName = "userid")
    private DimUser createdUserId;
    @ManyToOne
    @JoinColumn(name="reportreasonid", referencedColumnName = "reasonid")
    private DimReportReason reportReasonId;
    @Column(name = "createdttm")
    private LocalDateTime createDttm;
    @ManyToOne
    @JoinColumn(name="reportstatusid", referencedColumnName = "statusid")
    private DimReportStatus reportStatusId;
    @Column(length = 2000)
    private String description;
}
