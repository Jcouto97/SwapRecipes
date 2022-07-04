package mindera.midswap.SwapRecipes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //guarda automaticamente numa colecção
//receitas e ingredientes
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//HEROKU SERVER LINK (FOR POSTMAN)
	//swaprecipes nome DB
	//https://swaprecipes.herokuapp.com

	//SWAGGER
	//http://localhost:8080/swagger-ui/index.html
	//https://swaprecipes.herokuapp.com/swagger-ui/index.html

	//temos a DB com create-drop para não dar erro ao estar sempre a adicionar os Users do DataLoader (repetidos)

}
