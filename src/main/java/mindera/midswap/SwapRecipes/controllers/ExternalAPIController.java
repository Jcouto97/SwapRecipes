package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.externalApi.Results;
import mindera.midswap.SwapRecipes.externalApi.Type;
import mindera.midswap.SwapRecipes.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ExternalAPIController {
    //GET recipes
    //https://spoonacular.com/food-api/docs#Search-Recipes-Complex


    private final RecipeService recipeService;
    String uri = "https://api.spoonacular.com/";
    String apikey = "b028691f707a4dd48a1222aeef34bd81";

     // https://api.spoonacular.com/recipes/complexSearch?query=pasta&maxFat=25&number=2&apiKey=b028691f707a4dd48a1222aeef34bd81 //auth

    @GetMapping(path = "/ingredientsdb/{ingredient}")
    public ResponseEntity<Type> getRecipeByIngredientName(@PathVariable String ingredient) {

        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/complexSearch?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Type> result = restTemplate.getForEntity(finalUri, Type.class);
        return ResponseEntity.ok(result.getBody());
        //resposta do JSON com a minha api key
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
        //link site spoonacular para REQUEST
        //https://spoonacular.com/food-api/docs#Search-Recipes-Complex
    }


    //https://spoonacular.com/food-api/docs#Get-Analyzed-Recipe-Instructions
    @GetMapping(path = "/byrecipe/{recipeId}")
    public ResponseEntity<Type> getRecipeByIdInstructions(@PathVariable String recipeId) {

        //GET DO SITE SPOONACULAR
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&maxFat=25&number=2
        //GET DO SITE SPOONACULAR COM A MINHA API
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81

        //GET DO SITE SPOONACULAR
        // https://api.spoonacular.com/recipes/324694/analyzedInstructions
        //TENTATIVAS DE ENCONTRAR O LINK COM A MINHA API
        // https://api.spoonacular.com/recipes/324694/analyzedInstructions&apiKey=b028691f707a4dd48a1222aeef34bd81
        // https://api.spoonacular.com/recipes/complexSearch?query=324694/analyzedInstructions&apiKey=b028691f707a4dd48a1222aeef34bd81
        // https://api.spoonacular.com/recipes/search?query=324694/analyzedInstructions&apiKey=b028691f707a4dd48a1222aeef34bd81

        //https://api.spoonacular.com/food/products/search?query=324694&apiKey=b028691f707a4dd48a1222aeef34bd81
        //https://api.spoonacular.com/food/recipes/search?query=324694/analyzedInstructions&apiKey=b028691f707a4dd48a1222aeef34bd81
        //https://api.spoonacular.com/food/products/search?query=324694/analyzedInstructions&apiKey=b028691f707a4dd48a1222aeef34bd81
        //
        String finalUri = uri + "recipes/complexSearch?query=" + recipeId + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Type> result = restTemplate.getForEntity(finalUri, Type.class);
        return ResponseEntity.ok(result.getBody());
        //resposta do JSON com a minha api key
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
        //link site spoonacular para REQUEST
        //https://spoonacular.com/food-api/docs#Get-Analyzed-Recipe-Instructions
    }

    @GetMapping(path = "/recipeinformation/{recipeId}")
    public ResponseEntity<Type> getRecipeByIdInformation(@PathVariable String recipeId) {

        //GET DO SITE SPOONACULAR
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false
        //GET DO SITE SPOONACULAR COM A MINHA API
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false&apiKey=b028691f707a4dd48a1222aeef34bd81
        //LINK DE JSON QUE POSTMAN DEVOLVE PARA CONSTRUIR AS CLASSES
        //https://api.spoonacular.com/recipes/716429/information?includeNutrition=false&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/" + recipeId + "/information?includeNutrition=false&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Type> result = restTemplate.getForEntity(finalUri, Type.class);
        return ResponseEntity.ok(result.getBody());
        //resposta do JSON com a minha api key
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
        //link site spoonacular para REQUEST
        //https://spoonacular.com/food-api/docs#Get-Recipe-Information

    }





        // Move these classes to a separate file! Only here for demonstration purposes.
        public static class Film {
            public String Title;
            public String Year;
            public String Poster;
            public String Type;


            @Override
            public String toString() {
                return "Film{" +
                        "Title='" + Title + '\'' +
                        ", Year='" + Year + '\'' +
                        '}';
            }
        }


        public static class FilmList {
            public Film[] Search;

            @Override
            public String toString() {
                return "FilmList{" +
                        "Search=" + Arrays.toString(Search) +
                        '}';
            }
        }

    }
