package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;
import span4er.production.gamingbuddiesapi.repo.projections.NotificationsInfoForSearch;
import span4er.production.gamingbuddiesapi.service.JwtService;
import span4er.production.gamingbuddiesapi.service.NotificationsService;

import java.util.List;

import static span4er.production.gamingbuddiesapi.constant.Constant.BEARER_PREFIX;

@RestController
@RequestMapping("/notifications")
@Slf4j
@RequiredArgsConstructor
public class NotificationsResource {
    private final NotificationsService notificationsService;
    private final JwtService jwtService;
    @GetMapping
    public ResponseEntity<Page<NotificationsInfoForSearch>> searchNotifications(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                                @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                @RequestHeader(value = "Authorization", required = false) String token) {
        log.info("Received request to search notifications");
        try{
            var jwt = token.substring(BEARER_PREFIX.length());
            String userId = jwtService.extractUserId(jwt);
            log.info("Searching notifications for {}", userId);
            return ResponseEntity.ok().body(notificationsService.searchNotificationsByUser(page, size, Long.valueOf(userId)));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok().body(null);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Boolean> updateNotification(@PathVariable(value="id") long notificationId){
        log.info("Updating notification {}", notificationId);
        return ResponseEntity.ok().body(notificationsService.updateNotificationById(notificationId));
    }
}
