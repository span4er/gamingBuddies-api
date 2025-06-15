package span4er.production.gamingbuddiesapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private String username;

    public JwtAuthenticationResponse(String message) {
        this.token = message;
    }
}
