package com.demo.consumer.restClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    //uncomment below code for working
//    @Bean
//    @LoadBalanced
//    public RestClient.Builder loadbalancedRestClientBuilder(){
//        return RestClient.builder();
//    }

    @Bean
    public RestClient restClient(RestClient.Builder builder){
        return builder.baseUrl("http://provider")
                .build();
//        return builder.baseUrl("http://localhost:8081")
//                .build();
    }
}
