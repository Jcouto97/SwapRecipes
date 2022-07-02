package mindera.midswap.SwapRecipes.externalApi.MealDB;

//package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.externalApi.spoonacular.Type;
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

public class MealDBAPI {
    private final RecipeService recipeService;

    String uri = "http://www.themealdb.com/api/json/v1";
    String apikey = "1";



    @GetMapping(path = "/mealbyname/{mealname}")
    public ResponseEntity<Meals> getMeal(@PathVariable String mealname) {
        //www.themealdb.com/api/json/v1 /1/ lookup.php?i=52772
        String finalUri = uri + "/" + apikey + "/search.php?s=" + mealname;
        //String finalUri = uri + "?t=" + mealId + "&apikey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Meals> result = restTemplate.getForEntity(finalUri, Meals.class);
        System.out.println(result);
        return ResponseEntity.ok(result.getBody());
    }

//
//        {
//            "meals": [
//            {
//                "idMeal": "52771",
//                    "strMeal": "Spicy Arrabiata Penne",
//                    "strDrinkAlternate": null,
//                    "strCategory": "Vegetarian",
//                    "strArea": "Italian",
//                    "strInstructions": "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
//                    "strMealThumb": "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
//                    "strTags": "Pasta,Curry",
//                    "strYoutube": "https://www.youtube.com/watch?v=1IszT_guI08",
//                    "strIngredient1": "penne rigate",
//                    "strIngredient2": "olive oil",
//                    "strIngredient3": "garlic",
//                    "strIngredient4": "chopped tomatoes",
//                    "strIngredient5": "red chile flakes",
//                    "strIngredient6": "italian seasoning",
//                    "strIngredient7": "basil",
//                    "strIngredient8": "Parmigiano-Reggiano",
//                    "strIngredient9": "",
//                    "strIngredient10": "",
//                    "strIngredient11": "",
//                    "strIngredient12": "",
//                    "strIngredient13": "",
//                    "strIngredient14": "",
//                    "strIngredient15": "",
//                    "strIngredient16": null,
//                    "strIngredient17": null,
//                    "strIngredient18": null,
//                    "strIngredient19": null,
//                    "strIngredient20": null,
//                    "strMeasure1": "1 pound",
//                    "strMeasure2": "1/4 cup",
//                    "strMeasure3": "3 cloves",
//                    "strMeasure4": "1 tin ",
//                    "strMeasure5": "1/2 teaspoon",
//                    "strMeasure6": "1/2 teaspoon",
//                    "strMeasure7": "6 leaves",
//                    "strMeasure8": "spinkling",
//                    "strMeasure9": "",
//                    "strMeasure10": "",
//                    "strMeasure11": "",
//                    "strMeasure12": "",
//                    "strMeasure13": "",
//                    "strMeasure14": "",
//                    "strMeasure15": "",
//                    "strMeasure16": null,
//                    "strMeasure17": null,
//                    "strMeasure18": null,
//                    "strMeasure19": null,
//                    "strMeasure20": null,
//                    "strSource": null,
//                    "strImageSource": null,
//                    "strCreativeCommonsConfirmed": null,
//                    "dateModified": null
//            }
//    ]
//        }

//O QUE RECEBEMOS

//        {
//            "products": [
//            {
//                "id": 66932,
//                    "title": "noosa Yoghurt Lemon Whole Milk Yogurt 8oz",
//                    "jpeg": null
//            },
//            {
//                "id": 415312,
//                    "title": "noosa Yoghurt Coconut Whole Milk Yogurt 8oz",
//                    "jpeg": null
//            },
//            {
//                "id": 75544,
//                    "title": "noosa Yoghurt Raspberry Whole Milk Yogurt 8oz",
//                    "jpeg": null
//            },
//            {
//                "id": 75137,
//                    "title": "noosa Yoghurt Blueberry Whole Milk Yogurt 8oz",
//                    "jpeg": null
//            },
//            {
//                "id": 201369,
//                    "title": "Yoplait Yogurt, Lactose Free Yogurt, Peach, 6.0 oz",
//                    "jpeg": null
//            },
//            {
//                "id": 408236,
//                    "title": "Yoplait Go-Gurt, Low Fat Yogurt, Marvel Avengers Variety Pack, 16 oz",
//                    "jpeg": null
//            },
//            {
//                "id": 426506,
//                    "title": "Yoplait Go-Gurt, Low Fat Yogurt, Strawberry &amp; Berry Variety Pack, 48 oz",
//                    "jpeg": null
//            },
//            {
//                "id": 66981,
//                    "title": "Yoplait Greek Yogurt, 100 Calories, Fat Free Yogurt, Vanilla, 5.3 oz",
//                    "jpeg": null
//            },
//            {
//                "id": 89557,
//                    "title": "Yoplait Light Yogurt with Granola, Blueberry, Fat Free, 12 oz, 2 Cups",
//                    "jpeg": null
//            },
//            {
//                "id": 137739,
//                    "title": "Yoplait Greek Yogurt, 100 Calories, Fat Free Yogurt, Mixed Berry, 5.3 oz",
//                    "jpeg": null
//            }
//    ]
//        }
    }

