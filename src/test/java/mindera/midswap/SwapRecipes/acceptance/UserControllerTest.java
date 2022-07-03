package mindera.midswap.SwapRecipes.acceptance;

import io.restassured.RestAssured;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static mindera.midswap.SwapRecipes.MockedPojos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @MockBean
    UserJPARepository userJPARepository;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
    }

//    @Test
//        //Rest Template
//    void test_getStudentById_shouldReturnStudentWithId1() {
//        // arrange
//        when(authenticationProvider.getAuthentication(any(HttpServletRequest.class)))
//                .thenReturn(AUTHENTICATION_1);
//        when(userJPARepository.findById(1L))
//                .thenReturn(Optional.of(USER_ENTITY_1));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer something");
//        HttpEntity<Object> entity = new HttpEntity<>(headers);
//
//        // act
//        ResponseEntity<UserDto> response = restTemplate.exchange(
//                "/api/v1/user/1",
//                HttpMethod.GET,
//                entity,
//                UserDto.class);
//
//        // assert
//        verify(userJPARepository, times(1))
//                .findById(anyLong());
//        assertEquals(USER_DTO_NO_PASS_1, response.getBody());
//    }

}
