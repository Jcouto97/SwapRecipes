package mindera.midswap.SwapRecipes.persistence.repositories;

import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeJPARepository extends JpaRepository<Recipe, Long> {

    //nome da tabela DB used_ingredients | IJ usedIngredient
    //select * from ingredients i where i."name" like '%lime%'; | DB query
    @Query("Select r FROM Recipe r JOIN r.extendedIngredients i WHERE i.name LIKE %?1%")
    List<Recipe> findByIngredientName(String ingredientName);

    Optional<Recipe> findById(Long id);

    Optional<Object> findByTitle(String name);

    //props da Recipe
    //select * from recipe_category where category_id = 2; | DB query
    @Query("Select r FROM Recipe r JOIN r.categoryIds i WHERE i.id IN (?1)")
    List<Recipe> findByCategory(Long category);

    //select * from recipes r where r.vegetarian = true; | DB query
    @Query("Select r FROM Recipe r WHERE r.vegetarian = true")
    List<Recipe> findVegetarianRecipes();

    //select * from recipes r where r.vegan = true; | DB query
    @Query("Select r FROM Recipe r WHERE r.vegan = true")
    List<Recipe> findVeganRecipes();

    //select * from recipes r where r.gluten_free = true; | DB query
    @Query("Select r FROM Recipe r WHERE r.glutenFree = true")
    List<Recipe> findGlutenFreeRecipes();

    //select * from recipes r where r.dairy_free = true; | DB query
    @Query("Select r FROM Recipe r WHERE r.dairyFree = true")
    List<Recipe> findDairyFreeRecipes();
}
