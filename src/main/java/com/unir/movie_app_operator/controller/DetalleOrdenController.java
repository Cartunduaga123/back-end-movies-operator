package com.unir.movie_app_operator.controller;


import com.unir.movie_app_operator.persistence.entity.DetalleOrdenEntity;
import com.unir.movie_app_operator.persistence.entity.UserEntity;
import com.unir.movie_app_operator.service.DetalleOrdenService;
import com.unir.movie_app_operator.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DetalleOrdenController {
    private final DetalleOrdenService detalleOrdenService;

    @GetMapping("/detalle-orden")
    public ResponseEntity<List<DetalleOrdenEntity>> getAll() {
        return ResponseEntity.ok(this.detalleOrdenService.getAll());
    }

}
