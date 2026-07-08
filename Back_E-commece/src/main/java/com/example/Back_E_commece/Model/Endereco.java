package com.example.Back_E_commece.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Usuario;

    @Column(name = "Rua")
    private String Rua;

    @Column(name = "Numero")
    private String Numero;

    @Column(name = "Complemento")
    private String Complemento;

    @Column(name = "Cidade")
    private String Cidade;

    @Column(name = "Estado")
    private String Estado;

    @Column(name = "CEP")
    private String Cep;

}
