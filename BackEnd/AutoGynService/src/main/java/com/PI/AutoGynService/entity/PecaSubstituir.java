package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

@Entity
public class PecaSubstituir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descicao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;

    @ManyToOne
    private OS os;

    @ManyToOne
    private Peca peca;
}
