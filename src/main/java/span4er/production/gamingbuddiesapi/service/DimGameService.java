package span4er.production.gamingbuddiesapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.model.DimGame;
import span4er.production.gamingbuddiesapi.domain.model.GameSession;
import span4er.production.gamingbuddiesapi.repo.DimGameRepo;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class DimGameService {

    private final DimGameRepo dimGameRepo;

    public DimGame getGame(Long gameId) {
        return dimGameRepo.findDimGameByGameid(gameId).orElseThrow(() -> new RuntimeException("game not found"));
    }

    public Page<DimGame> searchDimGame(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dimGameRepo.findAll(pageable);
    }

    public DimGame updateGame (DimGame game) {
        return dimGameRepo.save(game);
    }
}
