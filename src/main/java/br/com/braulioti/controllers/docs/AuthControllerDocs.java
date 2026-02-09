package br.com.braulioti.controllers.docs;

import br.com.braulioti.data.dto.security.AccountCredentialsDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface AuthControllerDocs {
    @Operation(summary = "Authenticates an user and returns a token")
    ResponseEntity<?> signin(AccountCredentialsDTO credentials);

    @Operation(summary = "Refresh token for authenticated user and returns a token")
    ResponseEntity<?> refresh(String username, String refreshToken);

    AccountCredentialsDTO create(AccountCredentialsDTO credentials);
}
