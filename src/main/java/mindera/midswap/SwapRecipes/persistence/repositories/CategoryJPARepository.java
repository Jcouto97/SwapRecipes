package mindera.midswap.SwapRecipes.persistence.repositories;

import mindera.midswap.SwapRecipes.persistence.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryJPARepository extends JpaRepository<Category, Long> {

    Optional<Object> findByName(String name);
}
