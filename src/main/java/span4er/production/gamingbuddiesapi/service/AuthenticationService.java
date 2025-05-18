package span4er.production.gamingbuddiesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import span4er.production.gamingbuddiesapi.domain.dto.JwtAuthenticationResponse;
import span4er.production.gamingbuddiesapi.domain.dto.SignInRequest;
import span4er.production.gamingbuddiesapi.domain.dto.SignUpRequest;
import span4er.production.gamingbuddiesapi.domain.model.DimUserType;
import span4er.production.gamingbuddiesapi.domain.model.DimUser;
import span4er.production.gamingbuddiesapi.repo.DimUserTypeRepo;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final DimUserTypeRepo dimUserTypeRepo;
    private final DimUserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        final DimUserType COMMON_USER_TYPE = dimUserTypeRepo.getReferenceById(1);
        var user = new DimUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsertypeId(COMMON_USER_TYPE);

        userService.createDimUser(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .getDimUser(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
