package com.example.Back_E_commece.Model;

import com.example.Back_E_commece.Model.Enum.Roles;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    @OneToMany(mappedBy = "usuario")
    private ArrayList<Endereco> Enderecos  = new ArrayList<>();

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.Permicoes.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return  this.Senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
