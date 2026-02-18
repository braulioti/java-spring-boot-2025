package br.com.braulioti.integrationtests.testcontainers;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.stream.Stream;

@SpringJUnitConfig
public abstract class AbstractIntegrationTest {

    private static final boolean IS_CI = System.getenv("GITHUB_ACTIONS") != null;

    // Só criar Testcontainer se NÃO for CI
    static MySQLContainer<?> mysql = IS_CI ? null :
            new MySQLContainer<>("mysql:8.0.36")
                    .withReuse(true)
                    .withEnv("TESTCONTAINERS_RYUK_DISABLED", "true");

    static {
        if (!IS_CI) {
            try {
                Startables.deepStart(Stream.of(mysql)).join();
            } catch (Exception e) {
                System.err.println("⚠️ Não foi possível iniciar o MySQLContainer: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        if (IS_CI) {
            // MySQL do GitHub Actions
            registry.add("spring.datasource.url", () -> System.getenv("SPRING_DATASOURCE_URL"));
            registry.add("spring.datasource.username", () -> System.getenv("SPRING_DATASOURCE_USERNAME"));
            registry.add("spring.datasource.password", () -> System.getenv("SPRING_DATASOURCE_PASSWORD"));
        } else {
            // Testcontainers local
            registry.add("spring.datasource.url", mysql::getJdbcUrl);
            registry.add("spring.datasource.username", mysql::getUsername);
            registry.add("spring.datasource.password", mysql::getPassword);
        }
    }
}
