package com.example.Back_E_commece.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Usuario_ID")
    private Usuario usuario;

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
