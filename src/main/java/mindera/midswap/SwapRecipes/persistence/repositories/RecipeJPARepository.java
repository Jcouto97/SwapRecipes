package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeJPARepository extends JpaRepository<Recipe, Long> {

    //@Query("Select r FROM Recipe r JOIN r.ingredientsIds i WHERE i.id = ?1")
    @Query("Select r FROM Recipe r JOIN r.extendedIngredients i WHERE i.id = ?1")
    List<Recipe> findByIngredient(Long ingredientId);

    Optional<Recipe> findById(Long id);

    Optional<Object> findByTitle(String name);

    @Query("Select r FROM Recipe r JOIN r.categoryIds i WHERE i.id = ?1")
    List<Recipe> findByCategory(Long category);
}
