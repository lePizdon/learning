package org.example.learning.config;

import org.example.learning.client.RestClientProductsRestClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientProductsRestClientImpl productsRestClient(@Value("${server.port}") String baseUri) {
        return new RestClientProductsRestClientImpl(RestClient.builder()
                .baseUrl(baseUri)
                .build());
    }
}
