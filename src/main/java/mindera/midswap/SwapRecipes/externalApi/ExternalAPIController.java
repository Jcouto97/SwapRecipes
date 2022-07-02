package mindera.midswap.SwapRecipes.externalApi;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.externalApi.byingredient.Type;
import mindera.midswap.SwapRecipes.externalApi.byid.ApiRecipe;
import mindera.midswap.SwapRecipes.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ExternalAPIController {





    private final ExternalApiService externalApiService;
    private final RecipeService recipeService;
    String uri = "https://api.spoonacular.com/";
    //String apikey = "b028691f707a4dd48a1222aeef34bd81"; //elisa
    String apikey = "75f535603fa8415f8ce7778ca86ae7d1";

    //SEARCH BY INGREDIENT NAME
    //LINK POSTMAN localhost:8080/api/v1/ingredientsdb/yogurt
    @GetMapping(path = "/byingredient/{ingredient}")
    public ResponseEntity<Type> getRecipeByIngredientName(@PathVariable String ingredient) {

        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/complexSearch?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        //e preciso para transformar o JSON para aquilo que quero
        RestTemplate restTemplate = new RestTemplate();
        //sempre que chamarmos este Get, vamos ter a recipe -> "apiRecipe"
        ApiRecipe apiRecipe = restTemplate.getForObject(uri + "recipes/complexSearch?query=" + ingredient + "&apiKey=" + apikey, ApiRecipe.class);
        ResponseEntity<Type> result = restTemplate.getForEntity(finalUri, Type.class);
        return ResponseEntity.ok(result.getBody());
        //resposta do JSON com a minha api key
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
        //link site spoonacular para REQUEST
        //https://spoonacular.com/food-api/docs#Search-Recipes-Complex
    }


    @GetMapping(path = "/byid/{recipeId}")
    public ResponseEntity<ApiRecipe> getRecipeByIdInformation(@PathVariable String recipeId) {

        //GET DO SITE SPOONACULAR
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false
        //GET DO SITE SPOONACULAR COM A MINHA API
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false&apiKey=b028691f707a4dd48a1222aeef34bd81
        //LINK DE JSON QUE POSTMAN DEVOLVE PARA CONSTRUIR AS CLASSES
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/" + recipeId + "/information?includeNutrition=false&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        //e preciso para transformar o JSON para aquilo que quero
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiRecipe> result = restTemplate.getForEntity(finalUri, ApiRecipe.class);
        //do link q temos, aquilo passou o body para uma classe q tem estes elementos todos -> ApiRecipe
        ApiRecipe apiRecipe = restTemplate.getForObject(uri + "recipes/" + recipeId + "/information?includeNutrition=false&apiKey=" + apikey, ApiRecipe.class);
        this.externalApiService.saveApiInDataBase(apiRecipe);

        return ResponseEntity.ok(result.getBody());
        //resposta do JSON com a minha api key
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
        //link site spoonacular para REQUEST
        //https://spoonacular.com/food-api/docs#Get-Recipe-Information

    }


}
