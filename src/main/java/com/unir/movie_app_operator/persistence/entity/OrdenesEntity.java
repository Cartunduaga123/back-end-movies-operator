package com.unir.movie_app_operator.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ordenes")
@Data
public class OrdenesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_orden", nullable = false, columnDefinition = "serial")
    private Integer ordenID;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserEntity usuario;

    @ManyToOne
    @JoinColumn(name = "medioPagoID", nullable = false)
    private MediosDePagoEntity medioPago;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaOrden;

    @Column(nullable = false , columnDefinition = "Decimal(10,2)")
    private BigDecimal total;
}
