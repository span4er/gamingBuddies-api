package span4er.production.gamingbuddiesapi.domain.dto;

import lombok.Getter;
import lombok.Setter;
import span4er.production.gamingbuddiesapi.domain.model.DimGame;

import java.sql.Date;

@Getter
@Setter
public class DimGameDTO {
    private String name;
    private Long upvotescnt;
    private Long downvotescnt;
    private String gamedescription;
    private Date publisheddate;
    private String mainpicname;

    public DimGame convertToDimGame(Long gameId){
        DimGame dimGameEntity = new DimGame();

        dimGameEntity.setGameid(gameId);
        dimGameEntity.setName(name);
        dimGameEntity.setUpvotescnt(upvotescnt);
        dimGameEntity.setDownvotescnt(downvotescnt);
        dimGameEntity.setGamedescription(gamedescription);
        dimGameEntity.setPublisheddate(publisheddate);
        dimGameEntity.setMainpicname(mainpicname);

        return dimGameEntity;
    }
}
