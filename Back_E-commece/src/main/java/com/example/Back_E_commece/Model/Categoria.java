package com.example.Back_E_commece.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome")
    private String Categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produto = new ArrayList<>();

    public Categoria(){}

}
