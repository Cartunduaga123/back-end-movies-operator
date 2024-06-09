package com.unir.movie_app_operator.service;

import com.unir.movie_app_operator.persistence.entity.DetalleOrdenEntity;
import com.unir.movie_app_operator.persistence.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public DetalleOrdenService(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    public List<DetalleOrdenEntity> getAll() {
        return this.detalleOrdenRepository.findAll();
    }

    public DetalleOrdenEntity get(int detalleID) {
        return this.detalleOrdenRepository.findById(detalleID).orElse(null);
    }

}
