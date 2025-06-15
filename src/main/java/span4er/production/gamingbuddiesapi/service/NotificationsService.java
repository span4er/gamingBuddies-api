package span4er.production.gamingbuddiesapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.model.Notifications;
import span4er.production.gamingbuddiesapi.repo.NotificationsRepo;
import span4er.production.gamingbuddiesapi.repo.projections.NotificationsInfoForSearch;

import java.time.LocalDateTime;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class NotificationsService {
    private final NotificationsRepo notificationsRepo;

    public Page<NotificationsInfoForSearch> searchNotificationsByUser(int page, int size, Long userId) {
        Pageable pageable = PageRequest.of(page, size); // Создаем объект Pageable
        return notificationsRepo.findNotificationsByTargetUserUseridEquals(pageable, userId);
    }

    public Boolean updateNotificationById(long id){
        Notifications notifications = notificationsRepo.findById(id).orElse(null);
        notifications.setIsNotificationRead(true);
        notifications.setReadDttm(LocalDateTime.now());
        return notificationsRepo.save(notifications).getIsNotificationRead();
    }
}
