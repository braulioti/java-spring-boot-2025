package br.com.braulioti.integrationtests.controllers.withjson;

import br.com.braulioti.config.TestConfigs;
import br.com.braulioti.integrationtests.dto.AccountCredentialsDTO;
import br.com.braulioti.integrationtests.dto.TokenDTO;
import br.com.braulioti.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthControllerJsonTest extends AbstractIntegrationTest {

    private static TokenDTO token;

    @BeforeAll
    static void setUp() {
        token = new TokenDTO();
    }

    @Test
    @Order(1)
    void signin() {
        AccountCredentialsDTO credentials =
            new AccountCredentialsDTO("leandro", "admin123");

        token = given()
                .baseUri("http://localhost")
                .port(TestConfigs.SERVER_PORT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(credentials)
                .when()
                .post("/auth/signin")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(TokenDTO.class);

        assertNotNull(token.getAccessToken());
        assertNotNull(token.getRefreshToken());
    }

    @Test
    @Order(2)
    void refreshToken() {
        String username = "leandro";

        token = given()
                .baseUri("http://localhost")
                .port(TestConfigs.SERVER_PORT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header(TestConfigs.HEADER_PARAM_AUTHORIZATION, "Bearer " + token.getRefreshToken())
                .pathParam("username", username)
                .when()
                .put("/auth/refresh/{username}")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(TokenDTO.class);

        assertNotNull(token.getAccessToken());
        assertNotNull(token.getRefreshToken());
    }
}
