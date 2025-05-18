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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "mapuser2gamesession")
public class MapUser2GameSession {
    @Id
    @Column(name = "object_id", unique = true, updatable = false)
    private Long object_id;
//    @Column(name ="userid")
    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private DimUser userId;
    @Column(name ="gamesessionid")
    private Long gameSession;
    @Column(name = "createdttm")
    private LocalDateTime createDttm;
    @Column(name = "isdeleted")
    private Boolean isDeleted;
}
