# SwapRecipes


**Summary:**

Api created with the purpose of giving its users the ability to search desired recipes and adding them to their favourites list.
It also comes with easy to use functionalities for ingredient searching and category options (such as vegan recipes, for example).

**Requirements for setup:**

To run the program, download 65 files and compile in IDE or using javac in terminal. 
Can be deployed in heroku or locally (by switching NOTapplication.yml to application.yml, and vice versa).



**Also, 10 packages:**
- Commands: contains data transfer objects(DTO) used throughout the project;
- Config: used for initialing beans;
- Controllers: contains controllers for routes;
- Converters: for converting DTO into entities, and vice versa;
- Data loader: to set up database with predefined entities, and also consume from external API;
- ExternalAPI: for connecting to the external API;
- Persistence: stores the entities and their respective repositories;
- Security: security implemented with JWT token;
- Services: contains services for each entity;
- Test: unit tests.


**API endpoints:**

User:
- Add user -> POST Path: /api/v1/user + body in Json format
- Get all users -> GET Path: /api/v1/user
- Get user by id -> GET Path: /api/v1/user/{id}
- Delete user -> DELETE Path: /api/v1/user/{id}
- Update user -> PUT Path: /api/v1/user/{id} + body in Json format

Recipe:
- Add recipe -> POST Path: /api/v1/recipe + body in Json format
- Get all recipes -> GET Path: /api/v1/recipe
- Get recipe by id -> GET Path: /api/v1/recipe/{id}
- Delete recipe -> DELETE Path: /api/v1/recipe/{id}
- Update recipe -> PUT Path: /api/v1/recipe/{id} + body in Json format

Ingredients:
- Add ingredient -> POST Path: /api/v1/ingredient + body in Json format
- Get all ingredients -> GET Path: /api/v1/ingredient 
- Get ingredient by id -> GET Path: /api/v1/ingredient/{id}
- Delete ingredient -> DELETE Path: /api/v1/ingredient/{id}
- Update ingredient -> PUT Path: /api/v1/ingredient/{id} + body in Json format

Categories:
- Add category -> POST Path: /api/v1/category + body in Json format
- Get all categories -> GET Path: /api/v1/category
- Get category by id -> GET Path: /api/v1/category/{id}
- Delete category -> DELETE Path: /api/v1/category/{id}
- Update category -> PUT Path: /api/v1/category/{id} + body in Json format

Some more useful endpoints:
- Set favourite recipe to user -> PUT Path: /api/v1/recipes/{userId}/user-recipe/{recipeId}
- Give category to recipe -> PUT Path: /api/v1/recipes/{categoryId}/category-recipe/{recipeId}
- Give ingredient to recipe -> PUT Path: /api/v1/recipes/{ingredientId}/ingredient-recipe/{recipeId}
- Get recipe by given category -> GET Path: /api/v1/recipes/byCategoryId/{Id}
- Get recipe by different attributes (vegan, vegeterian, gluten free and dairy free recipes)
-> GET Path: /api/v1/recipes/{attribute}

