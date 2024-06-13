package com.unir.movie_app_operator.controller;

import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import com.unir.movie_app_operator.persistence.entity.UserEntity;
import com.unir.movie_app_operator.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/usuarios")
    @Operation(
            operationId = "Obtener Usuarios",
            description = "Operacion de lectura",
            summary = "Se devuelve una lista de todos los usuarios en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)))
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PostMapping("/usuarios")
    @Operation(
            operationId = "Insertar un usuario",
            description = "Operacion de escritura",
            summary = "Se crea un usuario a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del usuario a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el usuario con el identificador indicado.")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        if (user.getIdUser() == null || !this.userService.exists(user.getIdUser())) {
            return ResponseEntity.ok(this.userService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }
}
