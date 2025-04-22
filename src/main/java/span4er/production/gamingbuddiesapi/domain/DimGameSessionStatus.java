package span4er.production.gamingbuddiesapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "dimgamesessionstatus")
public class DimGameSessionStatus {
    @Id
    @Column(name = "sessionstatusid", unique = true, updatable = false)
    private Integer sessionStatusId;
    private String name;
    @Column(name = "isfinal")
    private Boolean isFinal;
}
