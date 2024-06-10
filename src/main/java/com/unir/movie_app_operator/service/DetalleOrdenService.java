package com.unir.movie_app_operator.service;

import com.unir.movie_app_operator.persistence.entity.DetalleOrdenEntity;
import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import com.unir.movie_app_operator.persistence.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import reactor.core.publisher.Mono;

@Service
public class DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;
    private WebClient.Builder webClientBuilder;

    @Autowired
    public DetalleOrdenService(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public List<DetalleOrdenEntity> getAll() {
        return this.detalleOrdenRepository.findAll();
    }

    public DetalleOrdenEntity get(int detalleID) {
        return this.detalleOrdenRepository.findById(detalleID).orElse(null);
    }

    public DetalleOrdenEntity save(DetalleOrdenEntity detalleOrdenEntity) {
        boolean movieExists = checkMovieExists(detalleOrdenEntity.getPeliculaID());
        if (movieExists) {
            this.detalleOrdenRepository.save(detalleOrdenEntity);
        }  else {
            throw new IllegalArgumentException("Movie does not exist");
        }
        return detalleOrdenEntity;
    }

    public void delete(int detalleID) {
        this.detalleOrdenRepository.deleteById(detalleID);
    }

    public boolean exists(int detalleID) {
        return this.detalleOrdenRepository.existsById(detalleID);
    }

    private boolean checkMovieExists(int movieId) {
        String url = "lb://movie-app-search/peliculas/exist/" + movieId;
        Mono<Boolean> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Boolean.class);
        return response.block();
    }

}
