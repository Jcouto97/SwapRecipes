package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;

public interface UserConverterI extends ConverterI<User, UserDto>{

     UserUpdateDto entityToUpdateDto(User user);

    User updateDtoToEntity(UserUpdateDto userUpdateDto, User user);

    UserUpdateDto entityToUpdateFavouritesDto(User user, Recipe recipe);

}
