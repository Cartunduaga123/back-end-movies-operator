package com.unir.movie_app_operator.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private  Integer idUser;

    @Column(nullable = false, length = 100, unique = false)
    private  String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private  String email;

    @Column(nullable = false, length = 100, unique = false)
    private  String contrasena;

    @Column(name="foto_perfil", nullable = true)
    private  String fotoPerfil;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date fechaRegistro;
}
