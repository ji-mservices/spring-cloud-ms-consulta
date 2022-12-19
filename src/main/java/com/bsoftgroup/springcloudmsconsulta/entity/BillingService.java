package com.bsoftgroup.springcloudmsconsulta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_cliente_producto")
@Getter
@Setter
@ToString
public class BillingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false, unique = true)
    private Long id;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "monto")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "producto")
    @JsonBackReference
    private Product product;

}
