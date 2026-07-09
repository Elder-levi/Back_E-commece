package com.example.Back_E_commece.Model;

import jakarta.persistence.*;

public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_Carrinho;


    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    public Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_produto")
    public Produto produto;

    @Column(name = "Quantidade")
    private int quantidade;


    
}