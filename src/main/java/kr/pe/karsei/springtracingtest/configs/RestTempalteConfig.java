package kr.pe.karsei.springtracingtest.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempalteConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
