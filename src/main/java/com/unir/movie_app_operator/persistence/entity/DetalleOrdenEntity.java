package com.unir.movie_app_operator.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "DetalleOrden")
@Data
public class DetalleOrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleID;

    @ManyToOne
    @JoinColumn(name = "ordenID", nullable = false)
    private OrdenesEntity orden;

    @Column(name = "peliculaID", nullable = false, columnDefinition = "Integer(10)")
    private Integer pelicula;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaTransaccion;

    @Column(nullable = false, columnDefinition = "Integer(10)")
    private Integer tiempoAlquiler;

    @Column(nullable = false , columnDefinition = "Decimal(10,2)")
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransaccion tipoTransaccion;

    public enum TipoTransaccion {
        ALQUILER, COMPRA
    }

}
