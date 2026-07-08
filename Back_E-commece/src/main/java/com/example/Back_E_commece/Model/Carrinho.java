package com.example.Back_E_commece.Model;

import jakarta.persistence.*;

public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_Carrinho;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_Usuario;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id_Produto;

    @Column(name = "Quantidade")
    private int quantidade;


    
}