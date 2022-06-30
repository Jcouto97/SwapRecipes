package mindera.midswap.SwapRecipes.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansInnit {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
