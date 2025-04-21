package span4er.production.gamingbuddiesapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "dimgame")
public class DimGame {
    @Id
    @Column(name = "gameid", unique = true, updatable = false)
    private Long gameid;
    private String name;
    @Nullable
    private Long upvotescnt;
    @Nullable
    private Long downvotescnt;
    @Column(length = 4000)
    private String gamedescription;
    private Date publisheddate;
    @Nullable
    private String mainpicname;
}
