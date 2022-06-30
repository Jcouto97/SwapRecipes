package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeJPARepository extends JpaRepository <Recipe, Long> {

   @Query("FROM Recipe WHERE ingredientId LIKE %?1%")
   List<Recipe> findByIngredient(String ingredient);

   public Optional<Recipe> findById(Long id);
}
