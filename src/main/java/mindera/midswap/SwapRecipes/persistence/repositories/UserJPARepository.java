package mindera.midswap.SwapRecipes.persistence.repositories;


import lombok.EqualsAndHashCode;
import mindera.midswap.SwapRecipes.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UserJPARepository extends JpaRepository<User, Long> {
//so para commit
    Optional<User> findById(Long id);
    Optional<Object> findByCitizenNumber(Long id);
}
