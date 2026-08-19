/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gvscolombia.placetopay.config;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Billy
 */
@Configuration
public class ServerConfig {
    
        
    @Value("${propiedades.resttemplate.conectTimeout}")
    private int conectTimeout;

    @Value("${propiedades.resttemplate.readTimeout}")
    private int readTimeout;
    
    
    
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create()
                    .setMaxConnTotal(20)
                    .setMaxConnPerRoute(5)
                    .build());
        clientHttpRequestFactory.setConnectTimeout(conectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        
        return clientHttpRequestFactory;
    }
  
    
}
