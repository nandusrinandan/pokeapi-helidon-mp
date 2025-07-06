package me.srsrks.mp.quickstart;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PokemonApiService {
    private final HttpClient client = HttpClient.newHttpClient();
    
    public String fetchPokemon(String endpoint) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch detail", e);
        }
    }
}