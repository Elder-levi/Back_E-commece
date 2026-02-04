package com.example.Back_E_commece.Model;


import jakarta.persistence.*;

@Entity
public class Produto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column (name = "Imagen")
private String img;

@Column (name = "Nome")
private String nome;

@Column(name = "Produto")
private String Produto;

@Column(name = "Preco")
private Double Preco;


    public String getImg() {return img;}

    public void setImg(String img) {this.img = img;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getProduto() {return Produto;}

    public void setProduto(String produto) {Produto = produto;}

    public Double getPreco() {return Preco;}

    public void setPreco(Double preco) {Preco = preco;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
