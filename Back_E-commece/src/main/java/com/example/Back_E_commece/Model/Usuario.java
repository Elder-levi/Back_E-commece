package com.example.Back_E_commece.Model;

import com.example.Back_E_commece.Model.Enum.Roles;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "Nome")
    private String nome;

    @Column( name = "Email")
    private String email;

    @Column(name = "Senha")
    private String Senha;

    @Column(name = "Role" )
    @Enumerated( EnumType.STRING )
    private Roles Permicoes;

    @Column(name = "DataDeCria")
    private LocalDateTime DataCria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Roles getPermicoes() {
        return Permicoes;
    }

    public void setPermicoes(Roles permicoes) {
        Permicoes = permicoes;
    }

    public LocalDateTime getDataCria() {
        return DataCria;
    }

    public void setDataCria(LocalDateTime dataCria) {
        DataCria = dataCria;
    }
}
