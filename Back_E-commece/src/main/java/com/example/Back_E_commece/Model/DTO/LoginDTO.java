package com.example.Back_E_commece.Model.DTO;



public class LoginDTO {

    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

private String email;

private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
