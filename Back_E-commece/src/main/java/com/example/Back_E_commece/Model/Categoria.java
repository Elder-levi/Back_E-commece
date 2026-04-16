@Entity
@Table(name = "Categorias")
public class Categoria
{
    @ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String Categoria;

    public class Categoria(){}

    public Long GetId()
    {
      return id
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