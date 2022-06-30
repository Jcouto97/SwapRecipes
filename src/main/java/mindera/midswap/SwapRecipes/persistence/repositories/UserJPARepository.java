package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserJPARepository extends JpaRepository<User, Long> {

   public Optional<User> findByIdNumber(Long idNumber);
    public Optional<User> findById(Long id);
}
