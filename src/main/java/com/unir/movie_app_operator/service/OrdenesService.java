package com.unir.movie_app_operator.service;

import com.unir.movie_app_operator.persistence.entity.DetalleOrdenEntity;
import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import com.unir.movie_app_operator.persistence.repository.DetalleOrdenRepository;
import com.unir.movie_app_operator.persistence.repository.OrdenesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenesService {

    private final OrdenesRepository ordenesRepository;

    @Autowired
    public OrdenesService(OrdenesRepository ordenesRepository) {
        this.ordenesRepository = ordenesRepository;
    }

    public List<OrdenesEntity> getAll() {
        return this.ordenesRepository.findAll();
    }

    public OrdenesEntity get(int ordenID) {
        return this.ordenesRepository.findById(ordenID).orElse(null);
    }
}
