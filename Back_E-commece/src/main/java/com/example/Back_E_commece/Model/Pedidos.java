import java.sql.Date;
import java.time.LocalDate;

public class Pedidos
{

@ID    
private long Id_Pedido; 

private Date Data_Pedido;

@OneToOne
@JoinCollumn(name = "id")
private Usuario usuario;

public Pedidos()
{
 Data_Pedido = LocalDate.now();
}


}