package com.demo.consumer.webClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    //uncomment below code for working
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder loadBalancedWebClient(){
//        return WebClient.builder();
//    }

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl("http://provider").build();
//        return builder.baseUrl("http://localhost:8081").build();
    }
}
