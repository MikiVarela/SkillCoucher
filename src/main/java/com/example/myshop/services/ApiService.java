package com.example.myshop.services;

import com.example.myshop.domain.Arma;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://eldenring.fanapis.com").build();
    }

    public List<Arma> getWeapons() {
        Mono<String> jsonResponseMono = this.webClient.get()
                .uri("/api/weapons?limit=20&page=3")
                .retrieve()
                .bodyToMono(String.class);

        String jsonResponse = jsonResponseMono.block();
        System.out.println(jsonResponseMono);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Arma> weapons = null;

        try {
            Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, new TypeReference<Map<String, Object>>() {});
            weapons = objectMapper.convertValue(responseMap.get("data"), new TypeReference<List<Arma>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(weapons);
        return weapons;
    }
}
