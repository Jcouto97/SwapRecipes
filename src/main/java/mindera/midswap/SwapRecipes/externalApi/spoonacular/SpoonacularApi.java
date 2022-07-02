package mindera.midswap.SwapRecipes.externalApi.spoonacular;

//package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
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

public class SpoonacularApi {
    private final RecipeService recipeService;

    String uri = "https://api.spoonacular.com/";
    String apikey = "75f535603fa8415f8ce7778ca86ae7d1";

//localhost:8080/api/v1/ingredientsdb/yogurt
//https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=75f535603fa8415f8ce7778ca86ae7d1

    //https://api.spoonacular.com/recipes/search?query=yogurt&apiKey=75f535603fa8415f8ce7778ca86ae7d1
    @GetMapping(path = "/ingredientsdb/{ingredient}")
    public ResponseEntity<Results> getMeal(@PathVariable String ingredient) {

        String finalUri = uri + "recipes/search?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Results> result = restTemplate.getForEntity(finalUri, Results.class);
        return ResponseEntity.ok(result.getBody());


//        "type":"product",
//                "products": [
//        {
//            "id":66932,
//                "title":"noosa Yoghurt Lemon Whole Milk Yogurt 8oz",
//                "image":"https://spoonacular.com/productImages/66932-312x231.jpeg",
//                "imageType":"jpeg"
//        },
//        {
//            "id":415312,
//                "title":"noosa Yoghurt Coconut Whole Milk Yogurt 8oz",
//                "image":"https://spoonacular.com/productImages/415312-312x231.jpeg",
//                "imageType":"jpeg"
//        },
//        {
//            "id":75544,
//                "title":"noosa Yoghurt Raspberry Whole Milk Yogurt 8oz",
//                "image":"https://spoonacular.com/productImages/75544-312x231.jpeg",
//                "imageType":"jpeg"
//        },
//        {
//            "id":75137,
//                "title":"noosa Yoghurt Blueberry Whole Milk Yogurt 8oz",
//                "image":"https://spoonacular.com/productImages/75137-312x231.jpeg",
//                "imageType":"jpeg"
//        },

//        {
//            "id":201369,
//                "title":"Yoplait Yogurt, Lactose Free Yogurt, Peach, 6.0 oz",
//                "image":"https://spoonacular.com/productImages/201369-312x231.jpeg",
//                "imageType":"jpeg"
//        },
//        {
//            "id":408236,
//                "title":"Yoplait Go-Gurt, Low Fat Yogurt, Marvel Avengers Variety Pack, 16 oz",
//                "image":"https://spoonacular.com/productImages/408236-312x231.png",
//                "imageType":"png"
//        },
//        {
//            "id":426506,
//                "title":"Yoplait Go-Gurt, Low Fat Yogurt, Strawberry &amp; Berry Variety Pack, 48 oz",
//                "image":"https://spoonacular.com/productImages/426506-312x231.png",
//                "imageType":"png"
//        },
//        {
//            "id":66981,
//                "title":"Yoplait Greek Yogurt, 100 Calories, Fat Free Yogurt, Vanilla, 5.3 oz",
//                "image":"https://spoonacular.com/productImages/66981-312x231.png",
//                "imageType":"png"
//        },
//        {
//            "id":89557,
//                "title":"Yoplait Light Yogurt with Granola, Blueberry, Fat Free, 12 oz, 2 Cups",
//                "image":"https://spoonacular.com/productImages/89557-312x231.png",
//                "imageType":"png"
//        },
//        {
//            "id":137739,
//                "title":"Yoplait Greek Yogurt, 100 Calories, Fat Free Yogurt, Mixed Berry, 5.3 oz",
//                "image":"https://spoonacular.com/productImages/137739-312x231.png",
//                "imageType":"png"
//        }
//    ],
//        "offset":0,
//                "number":10,
//                "totalProducts":3920,
//                "processingTimeMs":144,
//                "expires":1657014335515,
//                "isStale":false
//    }

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
}
