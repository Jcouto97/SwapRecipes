package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    public Optional<User> findById(Long id);

}
