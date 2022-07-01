package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeJPARepository extends JpaRepository <Recipe, Long> {

    @Query("Select r FROM Recipe r JOIN r.ingredientsIds i WHERE i.id = ?1")
   List<Recipe> findByIngredient(Long ingredientId);

  Optional<Recipe> findById(Long id);

  Optional<Object> findByName(String name);

    @Query("Select r FROM Recipe r JOIN r.categoryIds i WHERE i.name LIKE %?1%")
    List<RecipeDto> findByCategory(String category);
}
