package com.example.Back_E_commece.Model;

import jakarta.persistence.*;

@Table(name = "ItemPedido")
public class Itens_Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Quantidade")
    private int quantidade;

    @Column(name = "PrecoUnitario")
    private double preco_unitario;

}