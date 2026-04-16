package com.example.Back_E_commece.Model;

@Entity
@Table(name = "Categorias")
public class Categoria
{
    @ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String Categoria;

    public Categoria(){}


  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private Produto produto;


  public Produto GetProduto()
  {

   return produto;

  }


  public void SetPublic(Produto produto)
  {
  
  this.produto = produto;
   
  }
  
    
    public Long GetId()
    {
      return id;
    }
  
     public void SetId(Long id)
     {

        this.id = id;
     }

    public String GetCategoria()
    {
        return Categoria;
    }
    
    public void SetCategoria(String Categoria)
    {
       this.Categoria = Categoria;
    }

      


}
