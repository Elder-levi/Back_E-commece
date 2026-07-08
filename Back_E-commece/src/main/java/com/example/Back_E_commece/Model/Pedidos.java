package com.example.Back_E_commece.Model;
import com.example.Back_E_commece.Model.Enum.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Pedidos")
public class Pedidos{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long Id_Pedido;

 @Id
 @Column(name = "ID_Usuario")
 private long Id_Usuario;

 @Id
 @Column(name = "ID_Endereco")
 private long Id_Endereco;

 @Column(name = "Status")
 private Status status;

 @Column(name = "ValorTotal")
 private Double valorTotal;

 @Column(name = "DataPedido")
 private LocalDateTime Data_Pedido;

public Pedidos()
{
 this.Data_Pedido = LocalDateTime.now();
}



}