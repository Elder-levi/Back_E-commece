package com.example.Back_E_commece.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome")
    private String Categoria;

    public Categoria(){}

}
