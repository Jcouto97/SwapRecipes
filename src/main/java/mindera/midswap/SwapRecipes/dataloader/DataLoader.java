package mindera.midswap.SwapRecipes.dataloader;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.externalApi.byid.ApiRecipeList;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private UserJPARepository userJPARepository;
    private IngredientJPARepository ingredientJPARepository;
    private RecipeJPARepository recipeJPARepository;
    private RestTemplate restTemplate;
    private CategoryJPARepository categoryJPARepository;
    private ModelMapper modelMapper;

    //controllerEXT API VER

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //sempre que chamarmos este Get, vamos ter a recipe -> "apiRecipe"
        //receber a chamada da API, e transforma num obj ApiRecipeLit
        //Guarda as receitas que recebemos numa lista
        ApiRecipeList apiRecipeList = restTemplate.getForObject("https://api.spoonacular.com/recipes/random?number=50&apiKey=75f535603fa8415f8ce7778ca86ae7d1", ApiRecipeList.class);

        //popular a nossa DB, um por um!
        for (int i = 0; i < apiRecipeList.getRecipes().size(); i++) {
            Set<Ingredient> newIngredientList = new HashSet<>(); //novo set para cada receita
            Recipe newRecipe = modelMapper.map(apiRecipeList.getRecipes().get(i), Recipe.class); //para poder gravar na DB
            Ingredient ingredients = modelMapper.map(apiRecipeList.getRecipes().get(i).getExtendedIngredients(), Ingredient.class);
            newRecipe.getExtendedIngredients().stream()
                    .forEach(ingredient -> {
                        //bloqueio ingredients
                        if (!this.ingredientJPARepository.findByName(ingredient.getName()).isPresent()) {  //adiciona os ingredientes a DB
                            newIngredientList.add(this.ingredientJPARepository.saveAndFlush(ingredient));
                            //fim bloqueio
                        }
                    });
            newRecipe.setExtendedIngredients(newIngredientList); //adiciona os ingredientes à receita
            //esta linha estoura se fizermos deploy 2x
            this.recipeJPARepository.saveAndFlush(newRecipe);
//                this.ingredientJPARepository.saveAll(newRecipe.getExtendedIngredients());
        }
//        for (int i = 0; i < apiRecipeList.getRecipes().size(); i++) {
//            Recipe newRecipe1 = modelMapper.map(apiRecipeList.getRecipes().get(i), Recipe.class);
//
//        }


        //lista Users
        List<User> userList = new ArrayList<>(Arrays.asList(
                User.builder().name("Elisa")
                        .citizenNumber(100000001L)
                        .username("elisamoutinho")
                        .password("elisamoutinho")
                        .build(),
                User.builder().name("Ala")
                        .citizenNumber(100000002L)
                        .username("alakropa")
                        .password("alakropa")
                        .build(),
                User.builder().name("Joao")
                        .citizenNumber(100000003L)
                        .username("joaocouto")
                        .password("joaocouto")
                        .build()
        ));
        this.userJPARepository.saveAll(userList);
//
//        //lista Ingredients
//        List<Ingredient> ingredientList = new ArrayList<>(Arrays.asList(
//                Ingredient.builder().name("Banana").build(),
//                Ingredient.builder().name("Egg").build(),
//                Ingredient.builder().name("Carrot").build(),
//                Ingredient.builder().name("Pepper").build(),
//                Ingredient.builder().name("Milk").build(),
//                Ingredient.builder().name("Chocolate").build(),
//                Ingredient.builder().name("Sugar").build(),
//                Ingredient.builder().name("Water").build()
//        ));
//        this.ingredientJPARepository.saveAll(ingredientList);
//
//        List<Recipe> recipeList = new ArrayList<>(Arrays.asList(
//                Recipe.builder()
//                        .name("Pizza")
//                        .build(),
//                Recipe.builder()
//                        .name("Tea")
//                        .build(),
//                Recipe.builder()
//                        .name("Cappuccino")
//                        .build(),
//                Recipe.builder()
//                        .name("Feijoada")
//                        .build(),
//                Recipe.builder()
//                        .name("Hamburger")
//                        .build(),
//                Recipe.builder()
//                        .name("Pizza")
//                        .build(),
//                Recipe.builder()
//                        .name("Piri-piri chicken")
//                        .build(),
//                Recipe.builder()
//                        .name("Hummus")
//                        .build()
//        ));
//        this.recipeJPARepository.saveAll(recipeList);
//
//        List<Category> categoryList = new ArrayList<>(Arrays.asList(
//                Category.builder()
//                        .name("HotDrinks")
//                        .build(),
//                Category.builder()
//                        .name("Desserts")
//                        .build(),
//                Category.builder()
//                        .name("Breakfasts")
//                        .build(),
//                Category.builder()
//                        .name("MainDishes")
//                        .build(),
//                Category.builder()
//                        .name("Starters")
//                        .build(),
//                Category.builder()
//                        .name("Vegetarian")
//                        .build(),
//                Category.builder()
//                        .name("Vegan")
//                        .build(),
//                Category.builder()
//                        .name("GlutenFree")
//                        .build()
//        ));
//        this.categoryJPARepository.saveAll(categoryList);
//
    }
}
