package span4er.production.gamingbuddiesapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.DimGame;
import span4er.production.gamingbuddiesapi.domain.DimUser;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.domain.filters.GameSessionFilter;
import span4er.production.gamingbuddiesapi.repo.DimGameRepo;
import span4er.production.gamingbuddiesapi.repo.DimUserRepo;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class DimGameService {

    private final DimGameRepo dimGameRepo;

    public DimGame getGame(Long gameId) {
        return dimGameRepo.findDimGameByGameid(gameId).orElseThrow(() -> new RuntimeException("game not found"));
    }

    public Page<DimGame> searchDimGame(int page, int size, GameSessionFilter searchBody) {
        //Specification<GameSession> specification = buildSpecification(searchBody);
        Pageable pageable = PageRequest.of(page, size); // Создаем объект Pageable
        return dimGameRepo.findAll(pageable);
    }
}
