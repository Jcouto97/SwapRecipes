package mindera.midswap.SwapRecipes.acceptance;

import io.restassured.RestAssured;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @MockBean
    UserJPARepository userJPARepository;

    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
    }

}
