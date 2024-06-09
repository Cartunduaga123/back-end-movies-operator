package com.unir.movie_app_operator.controller;

import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import com.unir.movie_app_operator.persistence.entity.UserEntity;
import com.unir.movie_app_operator.service.UserService;
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
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        if (user.getIdUser() == null || !this.userService.exists(user.getIdUser())) {
            return ResponseEntity.ok(this.userService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }
}
