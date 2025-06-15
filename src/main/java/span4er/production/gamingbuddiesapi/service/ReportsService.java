package span4er.production.gamingbuddiesapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.model.Reports;
import span4er.production.gamingbuddiesapi.repo.ReportsRepo;
import span4er.production.gamingbuddiesapi.repo.projections.ReportInfoForGet;
import span4er.production.gamingbuddiesapi.repo.projections.ReportsInfoForSearch;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ReportsService {
    private final ReportsRepo reportsRepo;
    public Page<ReportsInfoForSearch> searchReports(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // Создаем объект Pageable
        return reportsRepo.findAllProjection(pageable);
    }

    public ReportInfoForGet getReportById(long id) {
        return reportsRepo.findByReportId(id).orElse(null);
    }
}
