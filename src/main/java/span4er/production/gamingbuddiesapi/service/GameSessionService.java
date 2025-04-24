package span4er.production.gamingbuddiesapi.service;


import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.GameSession;
import span4er.production.gamingbuddiesapi.domain.filters.GameSessionFilter;
import span4er.production.gamingbuddiesapi.repo.GameSessionRepo;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class GameSessionService {
    private final GameSessionRepo gameSessionRepo;

    public GameSession getGameSession(Long id) {
        return gameSessionRepo.findByGamesessionid(id).orElseThrow(() -> new RuntimeException("Gamesession not found"));
    }

    public Page<GameSessionInfoForSearch> searchGameSession(int page, int size, GameSessionFilter searchBody) {
        Specification<GameSession> specification = buildSpecification(searchBody);
        Pageable pageable = PageRequest.of(page, size); // Создаем объект Pageable
        return gameSessionRepo.findAllProjection(specification, pageable);
    }

    private Specification<GameSession> buildSpecification(GameSessionFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getCreateuserid() != null && !filter.getCreateuserid().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("createuserid")), "%" + filter.getCreateuserid().toUpperCase(Locale.ROOT) + "%"));
            }

            if (filter.getGameid() != null && !filter.getGameid().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("gameid"),"%" +filter.getGameid() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
