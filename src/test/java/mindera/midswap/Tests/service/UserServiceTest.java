package mindera.midswap.Tests.service;

import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceImpI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static mindera.midswap.Tests.MockedPojos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    private UserServiceI userServiceI;

    @Mock
    UserJPARepository userJPARepository;

    @Mock
    UserConverterI userConverterI;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        this.userServiceI = new UserServiceImpI(userJPARepository, userConverterI, passwordEncoder);
    }

    @Nested
    class getUserByIdTest {


        @Test
        void getUsersSizeTest(){
            when(userJPARepository.findAll()).thenReturn(List.of(USER_ENTITY_1, USER_ENTITY_2));

            // assert
            assertEquals(2, userJPARepository.findAll().size());
        }


        @Test
        void testGetUserByIdNotFound() {   //PORQUE FUNCIONA?
            // arrange
            when(userJPARepository.findById(55L))
                    .thenReturn(Optional.empty());

            // atc
            Executable action = () -> userServiceI.getUserById(55L);

            // assert
            assertThrows(UserNotFoundException.class, action);
        }
    }
}

