package dev.shroysha.pokemon.app.client.controller;

import dev.shroysha.pokemon.ejb.PokemonTrainer;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static dev.shroysha.pokemon.ejb.PokemonEntityScanTag.BASE_URL;
import static dev.shroysha.pokemon.ejb.PokemonEntityScanTag.TRAINER_CREATE;

public class PokemonClientController {


    public static final WebClient WEB_CLIENT = WebClient.create(BASE_URL);


    @Getter
    private static PokemonTrainer loggedInTrainer;

    public static void trainerCreate(String username) {
        MultiValueMap<String, String> postData = new LinkedMultiValueMap<>();
        postData.add("trainerName", username);

        loggedInTrainer = WEB_CLIENT.post()
                .uri(TRAINER_CREATE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromMultipartData(postData))
                .retrieve()
                .bodyToMono(PokemonTrainer.class)
                .block();
    }
}
