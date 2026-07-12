package com.example.Back_E_commece.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
private Long id;

@Column (name = "Imagen")
private String CaminhoIMG;

@Column (name = "Nome")
private String nome;

@Column(name = "Descricao")
private String Descricao;

@Column(name = "Preco")
private Double preco;

@Column(name = "Estoque")
private int estoque;


@ManyToOne
@JoinColumn(name = "ID_Carinho")
private Carrinho carrinho;

@ManyToOne
@JoinColumn(name = "ID_Categtoria")
private Categoria categoria;    

@ManyToOne
@JoinColumn(name = "ID_pedidos")    
private Pedidos pedidos;


    public String getCaminhoIMG() {
        return CaminhoIMG;
    }

    public void setCaminhoIMG(String caminhoIMG) {
        CaminhoIMG = caminhoIMG;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return Descricao;}

    public void setDescricao(String descricao) {Descricao = descricao;}

    public Double getPreco() {return preco;}

    public void setPreco(Double preco) {this.preco = preco;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public Categoria GetCategoria()
    {
        return categoria;
    }

    public void SetCategoria( Categoria categoria)
    {
        this.categoria = categoria; 
    }
}
