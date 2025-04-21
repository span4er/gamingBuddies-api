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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import span4er.production.gamingbuddiesapi.domain.Contact;
import span4er.production.gamingbuddiesapi.domain.DimUser;
import span4er.production.gamingbuddiesapi.domain.filters.DimUserFilter;
import span4er.production.gamingbuddiesapi.repo.DimUserRepo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static span4er.production.gamingbuddiesapi.constant.Constant.PHOTO_DIRECTORY;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class DimUserService {
    private final DimUserRepo dimUserRepo;


    public Page<DimUser> searchDimUser(int page, int size, DimUserFilter searchBody) {
        Specification<DimUser> specification = buildSpecification(searchBody);
        Pageable pageable = PageRequest.of(page, size); // Создаем объект Pageable
        return dimUserRepo.findAll(specification, pageable);
    }

    private Specification<DimUser> buildSpecification(DimUserFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getUserlogin() != null && !filter.getUserlogin().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("userlogin")), "%" + filter.getUserlogin().toUpperCase(Locale.ROOT) + "%"));
            }

            if (filter.getUsername() != null && !filter.getUsername().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("username"),"%" +filter.getUsername() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public DimUser getDimUser(String login) {
        return dimUserRepo.findByUserlogin(login).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public DimUser createDimUser(DimUser dimUser) {
        return dimUserRepo.save(dimUser);
    }

    public String uploadPhoto(String id, MultipartFile file) {
        log.info("Saving picture for user ID: {}", id);
        DimUser dimUser = getDimUser(id);
        String photoUrl = photoFunction.apply(id, file);
        dimUser.setUserpicname(photoUrl);
        dimUserRepo.save(dimUser);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".") + 1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) -> {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if(!Files.exists(fileStorageLocation)) { Files.createDirectories(fileStorageLocation); }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/users/image/" + filename).toUriString();
        }catch (Exception exception) {
            throw new RuntimeException("Unable to save image");
        }
    };
}
