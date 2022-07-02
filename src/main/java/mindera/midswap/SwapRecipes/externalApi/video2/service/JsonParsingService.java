package mindera.midswap.SwapRecipes.externalApi.video2.service;

import mindera.midswap.SwapRecipes.externalApi.video2.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

public class JsonParsingService implements ParsingService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url, Object.class);
    }
}
