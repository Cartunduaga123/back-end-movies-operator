package com.unir.movie_app_operator.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MediosDePago")
@Data
public class MediosDePagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medioPagoID;

    @Column(nullable = false, length = 50)
    private String tipoMedioPago;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String detalles;
}
