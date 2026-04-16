package com.example.Back_E_commece.Model;

public class Carrinho {


    public Long id_Carrinho;


    @OneToOne
    @JoinCollumn(name = "id" , unique = true)
    public Usuario usuario;

   public Usuario GetUsuario()
   {
    return usuario;
   }

   public void SetUsuario( Usuario usuario)
   {
  
      this.usuario = usuario;

   }

   public Long GetID()
   {
    return this.id_Carrinho;
   }

   public void SetId( Long id )
   {
     this.id_Carrinho = id;
   }

    
}