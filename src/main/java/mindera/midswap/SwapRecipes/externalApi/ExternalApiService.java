package mindera.midswap.SwapRecipes.externalApi;

import mindera.midswap.SwapRecipes.externalApi.byid.ApiRecipe;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExternalApiService {

    private RecipeJPARepository recipeJPARepository;
    private IngredientJPARepository ingredientJPARepository;
    private ModelMapper modelMapper;
    //conversor do ApiDto para entity

    @Autowired
    public ExternalApiService(RecipeJPARepository recipeJPARepository, IngredientJPARepository ingredientJPARepository, ModelMapper modelMapper) {
        this.recipeJPARepository = recipeJPARepository;
        this.ingredientJPARepository = ingredientJPARepository;
        this.modelMapper = modelMapper;
    }

    public Recipe saveApiInDataBase(ApiRecipe apiRecipe){
        Recipe newRecipe = modelMapper.map(apiRecipe, Recipe.class);
  //      Set<Ingredient> newIngredients = new HashSet<>();
        newRecipe.getExtendedIngredients().stream()
                .forEach(ingredient -> this.ingredientJPARepository.save(ingredient));
//        for (int i = 0; i < newRecipe.getExtendedIngredients().size(); i++) {
//            this.ingredientJPARepository.save(newRecipe.getExtendedIngredients())
//        }
        //this.ingredientJPARepository.saveAll(newRecipe.getExtendedIngredients());
        return this.recipeJPARepository.save(newRecipe);
    }



}
