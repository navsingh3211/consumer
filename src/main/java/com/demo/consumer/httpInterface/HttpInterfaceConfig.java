package com.demo.consumer.httpInterface;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientLoadbalancer(){
        return WebClient.builder();
    }

    @Bean
    public ProviderHttpInterface webClientHttpInterface(WebClient.Builder webClinetBuilder){
        WebClient webClient = webClinetBuilder.baseUrl("http://provider").build();

        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(adapter).build();

        ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
        return service;
    }

//    @Bean
//    @LoadBalanced
//    public RestClient.Builder loadBalancedWebClientInHttpInterface(){
//        return RestClient.builder();
//    }
//
//    @Bean
//    public ProviderHttpInterface restClientHttpInterface(RestClient.Builder restClientBuilder){
//        RestClient restClient = restClientBuilder.baseUrl("http://provider").build();
////        RestClient restClient = RestClient.builder().baseUrl("http://provider").build();
//        RestClientAdapter adapter = RestClientAdapter.create(restClient);
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
//
//        ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
//        return service;
//    }
}
