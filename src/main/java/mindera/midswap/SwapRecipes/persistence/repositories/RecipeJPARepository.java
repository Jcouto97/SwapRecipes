package mindera.midswap.SwapRecipes.persistence.repositories;

import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeJPARepository extends JpaRepository <Recipe, Long> {

    @Query("FROM Recipe WHERE ingredientList LIKE %?1%")
    List<Recipe> findByIngredient(String ingredient);
}
