package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;

import mindera.midswap.SwapRecipes.services.RecipeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/v1")

//public class ExternalAPIController {
//    private final RecipeService recipeService;
//    String uri = "http://www.themealdb.com/api/json/v1";
//    String apikey = "1";
//
//
//
//    @GetMapping(path = "/mealbyid/{mealId}")
//    public ResponseEntity<Recipe> getMeal(@PathVariable String mealId) {
//        //www.themealdb.com/api/json/v1 /1/ lookup.php?i=52772
//        String finalUri = uri + "/" + apikey + "/lookup.php?i=" + mealId;
//        //String finalUri = uri + "?t=" + mealId + "&apikey=" + apikey;
//        System.out.println("finalUri = " + finalUri);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Recipe> result = restTemplate.getForEntity(finalUri, Recipe.class);
//        return ResponseEntity.ok(result.getBody());
//    }
///*
//*   @GetMapping("/{id}") //se nao tivesses {} tinha que estar no path (como o search)
//    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id) {
//        StudentDto studentDto = this.studentService.getStudentById(id);
//        if (studentDto == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(studentDto, HttpStatus.OK);
//    }*/
//    /*
//    *  @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
//        Student student = this.studentService.getStudentById(id);
//        if (student == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }*/
//
//    @GetMapping(path = "/mealbyid2/{mealId}")
//    public ResponseEntity<RecipeDto> getMeal2(@PathVariable String mealId) {
//        //www.themealdb.com/api/json/v1 /1/ lookup.php?i=52772
//        String finalUri = uri + "/" + apikey + "/lookup.php?i=" + mealId;
//        //String finalUri = uri + "?t=" + mealId + "&apikey=" + apikey;
//        System.out.println("finalUri = " + finalUri);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<RecipeDto> result = restTemplate.getForEntity(finalUri, RecipeDto.class);
//        return ResponseEntity.ok(result.getBody());
//    }
//
//
//
//
////    @GetMapping(path = "/mealbyid2/{mealId}")
////    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable("id") Long mealId) {
////        //vai buscar a meal da API externa
////        String finalUri = uri + "/" + apikey + "/lookup.php?i=" + mealId;
////        RestTemplate restTemplate = new RestTemplate();
////        ResponseEntity<RecipeDto> result = restTemplate.getForEntity(finalUri, RecipeDto.class);
////        return ResponseEntity.ok(result.getBody());
////        //guardar a receita que recebemos no body do json
////        //return this.recipeService.getRecipeById(id);
////    }
//
//    @GetMapping("/byId/{id}")
//    public RecipeDto getRecipeByIdlalalal(@PathVariable("id") Long id) {
//        return this.recipeService.getRecipeById(id);
//    }
//
////    @PutMapping("/{userId}/{recipeId}")
////    public UserDto addRecipeToFavourites(@PathVariable("userId") Long userId, @PathVariable("recipeId") Long
////            recipeId) {
////        //return this.userServiceI.saveFavouriteRecipe(userId, recipeId);
////        return this.recipeService.saveFavouriteRecipe(userId, recipeId);
////    }
//
//
//    @GetMapping(path = "recipe/{search}")
//    public ResponseEntity<FilmList> getFilms(@PathVariable String search) {
//        String finalUri = uri + "?s=" + search + "&apikey=" + apikey;
//        System.out.println("finalUri = " + finalUri);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<FilmList> result = restTemplate.getForEntity(finalUri, FilmList.class);
//        return ResponseEntity.ok(result.getBody());
//    }
//
//    // Move these classes to a separate file! Only here for demonstration purposes.
//    public static class Recipe {
//        public String Title;
//        public String Year;
//        public String Poster;
//        public String Type;
//
//
//        @Override
//        public String toString() {
//            return "Film{" +
//                    "Title='" + Title + '\'' +
//                    ", Year='" + Year + '\'' +
//                    '}';
//        }
//    }
//
//
//    public static class FilmList {
//        public Recipe[] Search;
//
//        @Override
//        public String toString() {
//            return "FilmList{" +
//                    "Search=" + Arrays.toString(Search) +
//                    '}';
//        }
//    }
//
//}
