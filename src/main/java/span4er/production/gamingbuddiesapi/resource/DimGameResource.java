package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import span4er.production.gamingbuddiesapi.domain.DimGame;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.domain.filters.GameSessionFilter;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;
import span4er.production.gamingbuddiesapi.service.DimGameService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import static span4er.production.gamingbuddiesapi.constant.Constant.GAME_ICONS_DIRECTORY;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class DimGameResource {

    private final DimGameService dimGameService;

    @GetMapping(path = "/game/image/{filename}", produces = { IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE })
    public byte[] getPhoto(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(GAME_ICONS_DIRECTORY + filename));
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<DimGame> getGame(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(dimGameService.getGame(id));
    }

    @GetMapping
    public ResponseEntity<Page<DimGame>> searchDimGame(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                             @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(dimGameService.searchDimGame(page, size));
    }
}
