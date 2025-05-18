package span4er.production.gamingbuddiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import span4er.production.gamingbuddiesapi.domain.model.DimUser;
import span4er.production.gamingbuddiesapi.service.DimUserService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import static span4er.production.gamingbuddiesapi.constant.Constant.USER_AVATAR_DIRECTORY;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class DimUserResource {
    private final DimUserService dimUserService;

    @PostMapping
    public ResponseEntity<DimUser> createUser(@RequestBody DimUser dimUser) {
        return ResponseEntity.created(URI.create("/users/userID")).body(dimUserService.createDimUser(dimUser));
    }

    @GetMapping
    public ResponseEntity<Page<DimUser>> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(dimUserService.searchDimUser(page, size));
    }

    @GetMapping("/{login}")
    public ResponseEntity<DimUser> getUser(@PathVariable(value = "login") String login) {
        return ResponseEntity.ok().body(dimUserService.getDimUser(login));
    }

    @PutMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam("userlogin") String userLogin, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok().body(dimUserService.uploadPhoto(userLogin, file));
    }

    @GetMapping(path = "/image/{filename}", produces = { IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE })
    public byte[] getPhoto(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(USER_AVATAR_DIRECTORY + filename));
    }
}
