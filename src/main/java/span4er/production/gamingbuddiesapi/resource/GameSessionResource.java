package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.domain.filters.GameSessionFilter;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;
import span4er.production.gamingbuddiesapi.service.GameSessionService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class GameSessionResource {
    private final GameSessionService gameSessionService;

    @PostMapping
    public ResponseEntity<Page<GameSessionInfoForSearch>> searchGameSessions(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                             @RequestParam(value = "size", defaultValue = "10") int size,
                                                                             @RequestBody GameSessionFilter searchBody) {
        return ResponseEntity.ok().body(gameSessionService.searchGameSession(page, size, searchBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSession> getGameSession(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(gameSessionService.getGameSession(id));
    }

}
