package mindera.midswap.SwapRecipes.unit.service;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceImpI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.Column;
import java.util.Optional;

import static mindera.midswap.SwapRecipes.MockedPojos.USER_ENTITY_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    UserServiceI userServiceI;

    @Mock
    UserJPARepository userJPARepository;

    @Mock
    UserConverterI userConverterI;

    @Mock
    RecipeServiceI recipeServiceI;

    @Mock
    RecipeJPARepository recipeJPARepository;

    @BeforeEach
    public void setup() {
        this.userServiceI = new UserServiceImpI(userJPARepository, userConverterI, recipeServiceI, recipeJPARepository);
    }

    @Nested
    class getStudentByIdTest {

        @Test
        void testGetUserByIdSuccess() {
            // arrange
            when(userJPARepository.findById(1L))
                    .thenReturn(Optional.of(USER_ENTITY_1));

            // act
            UserDto result = userServiceI.findById(1L);

            // assert
            assertEquals(USER_ENTITY_1, result);
        }

        @Test
        void testGetStudentByIdNotFound() {
            // arrange
            when(userJPARepository.findById(1L))
                    .thenReturn(Optional.empty());

            // atc
            Executable action = () -> userServiceI.findById(1L);

            // assert
            assertThrows(UserNotFoundException.class, action);
        }


    }
}
