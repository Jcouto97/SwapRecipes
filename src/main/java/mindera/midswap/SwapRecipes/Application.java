package mindera.midswap.SwapRecipes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableCaching //guarda automaticamente numa colecção
//receitas e ingredientes
@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserServiceImpI userService) {
//		return args -> {
//			//read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//			try {
//				List<User> users = mapper.readValue(inputStream, typeReference);
//				userService.saveMultipleUsers(users);
//				System.out.println("Users saved!");
//			}
//			catch (IOException e) {
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//
//		};
//	}

}
