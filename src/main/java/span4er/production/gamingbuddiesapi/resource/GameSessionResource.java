package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import span4er.production.gamingbuddiesapi.domain.dto.GameSessionDTO;
import span4er.production.gamingbuddiesapi.domain.model.GameSession;
import span4er.production.gamingbuddiesapi.repo.*;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;
import span4er.production.gamingbuddiesapi.service.GameSessionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
@Slf4j
@RequiredArgsConstructor
public class GameSessionResource {
    private final GameSessionService gameSessionService;

    @GetMapping
    public ResponseEntity<Page<GameSessionInfoForSearch>> searchGameSessions(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                             @RequestParam(value = "size", defaultValue = "10") int size,
                                                                             @RequestParam(value = "platformIds", required = false) List<String> platformIds) {
        log.info("Recevied platform array {}", platformIds);
        return ResponseEntity.ok().body(gameSessionService.searchGameSession(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSession> getGameSession(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(gameSessionService.getGameSession(id));
    }

    @PostMapping()
    public ResponseEntity<Long> createGameSession(@RequestBody GameSessionDTO gameSession){
        return ResponseEntity.ok().body(gameSessionService.createGameSession(gameSession));
    }

}
