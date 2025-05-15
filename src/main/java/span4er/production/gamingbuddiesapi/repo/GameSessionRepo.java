package span4er.production.gamingbuddiesapi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameSessionRepo extends JpaRepository<GameSession, Long>, JpaSpecificationExecutor<GameSession> {
    Optional<GameSession> findByGamesessionid(Long id);

    @Query("select \n" +
                "gs.gamesessionid as gameSessionId,\n" +
                "gs.sessiondescription as sessionDescription,\n" +
                "gs.name as sessionName,\n" +
                "gs.createuser.userlogin as createUserLogin,\n" +
                "gs.createuser.userpicname as createUserPicName,\n" +
                "gs.createdttm as createDttm,\n" +
                "gs.startdttm as startDttm,\n" +
                "gs.enddttm as endDttm,\n" +
                "gs.capacitynum as capacityNum,\n" +
                "gs.category.name as categoryName,\n" +
                "gs.game.gameid as gameId,\n" +
                "gs.game.mainpicname as gamePicName,\n" +
                "gs.language.nameShort as languageShort,\n" +
                "gs.sessionstatus.sessionStatusId as sessionStatusId,\n" +
                "gs.sessionstatus.name as sessionStatusName,\n" +
                "gs.platform.name as gamingPlatform\n"+
                "from GameSession gs")
    Page<GameSessionInfoForSearch> findAllProjection(Pageable pageable);
}
