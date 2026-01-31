package br.com.braulioti.controllers.docs;

import br.com.braulioti.data.dto.request.EmailRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface EmailControllerDocs {
    @Operation(summary = "Send an e-mail",
            description = "Sends an e-mail by providing details, subject and body!",
            tags = {"E-mail"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    ResponseEntity<String> sendMail(EmailRequestDTO emailRequestDTO);

    @Operation(summary = "Send an e-mail with Attachment",
            description = "Sends an e-mail with attachment by providing details, subject and body!",
            tags = {"E-mail"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    ResponseEntity<String> sendMailWithAttachment(String emailRequestJson, MultipartFile multipartFile);
}
