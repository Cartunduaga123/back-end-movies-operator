package com.unir.movie_app_operator.controller;

import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import com.unir.movie_app_operator.service.OrdenesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdenesController {
    private final OrdenesService ordenesService;

    @GetMapping("/ordenes")
    public ResponseEntity<List<OrdenesEntity>> getAll() {
        return ResponseEntity.ok(this.ordenesService.getAll());
    }

    @GetMapping("/ordenes/{ordenID}")
    public ResponseEntity<OrdenesEntity> get(@PathVariable int ordenID)  {
        return ResponseEntity.ok(this.ordenesService.get(ordenID));
    }

    @PostMapping("/ordenes")
    public ResponseEntity<OrdenesEntity> add(@RequestBody OrdenesEntity orden) {
        if (orden.getOrdenID() == null || !this.ordenesService.exists(orden.getOrdenID())) {
            return ResponseEntity.ok(this.ordenesService.save(orden));
        }
        return ResponseEntity.badRequest().build();
    }
}
