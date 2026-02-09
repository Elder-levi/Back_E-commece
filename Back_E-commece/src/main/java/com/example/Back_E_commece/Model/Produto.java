package com.example.Back_E_commece.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column (name = "Imagen")
private String img;

@Column (name = "Nome")
private String nome;

@Column(name = "Descricao")
private String Descricao;

@Column(name = "Preco")
private Double preco;


    public String getImg() {return img;}

    public void setImg(String img) {this.img = img;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return Descricao;}

    public void setDescricao(String descricao) {Descricao = descricao;}

    public Double getPreco() {return preco;}

    public void setPreco(Double preco) {this.preco = preco;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
