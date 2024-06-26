package com.unir.movie_app_operator.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_orden")
@Data
@Getter
@Setter
@NoArgsConstructor
public class DetalleOrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    private Integer detalleID;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenesEntity orden;

    @Column(name = "pelicula_id", nullable = false)
    private Integer peliculaID;

    @Column(name = "fecha_transaccion", nullable = false, columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaTransaccion;

    @Column(name = "tiempo_alquiler", nullable = false)
    private Integer tiempoAlquiler;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion", nullable = false)
    private TipoTransaccion tipoTransaccion;

    public enum TipoTransaccion {
        ALQUILER, COMPRA
    }
}
