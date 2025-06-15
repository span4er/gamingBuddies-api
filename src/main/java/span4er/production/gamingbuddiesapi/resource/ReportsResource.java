package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import span4er.production.gamingbuddiesapi.domain.model.GameSession;
import span4er.production.gamingbuddiesapi.domain.model.Reports;
import span4er.production.gamingbuddiesapi.repo.ReportsRepo;
import span4er.production.gamingbuddiesapi.repo.projections.GameSessionInfoForSearch;
import span4er.production.gamingbuddiesapi.repo.projections.ReportInfoForGet;
import span4er.production.gamingbuddiesapi.repo.projections.ReportsInfoForSearch;
import span4er.production.gamingbuddiesapi.service.GameSessionService;
import span4er.production.gamingbuddiesapi.service.ReportsService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@Slf4j
@RequiredArgsConstructor
public class ReportsResource {
    private final ReportsService reportsService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<ReportsInfoForSearch>> searchReports(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                    @RequestParam(value = "size", defaultValue = "10") int size) {
//        log.info("Recevied platform array {}", platformIds);
        return ResponseEntity.ok().body(reportsService.searchReports(page, size));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReportInfoForGet> getReportById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(reportsService.getReportById(id));
    }
}
