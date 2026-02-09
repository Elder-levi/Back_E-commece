package com.example.Back_E_commece.Controller;


import com.example.Back_E_commece.Model.DTO.ProdutosDTO;
import com.example.Back_E_commece.Model.Produto;
import com.example.Back_E_commece.Service.ServiceProd;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Prod")
public class ControllesProd {

    private final ServiceProd ServProd;

    public ControllesProd(ServiceProd servProd) {
        ServProd = servProd;
    }

    @GetMapping()
    public String Teste()
    {
        return "Testando";
    }

    @GetMapping("/Produtos")
    public List<Produto> GetProd()
    {
        return ServProd.GetPro();
    }


    @PostMapping(value = "/Cad/Produto"/*, consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/)
    public ResponseEntity<Produto> Cadastro(
            @RequestPart("produto") ProdutosDTO dto
    ) throws IOException {

        System.out.println("Nome: " + dto.nome);
        System.out.println("Descricao: " + dto.descricao);
        System.out.println("Preco: " + dto.preco);

        Produto NewPro = new Produto();
        NewPro.setNome(dto.nome);
        NewPro.setDescricao(dto.descricao);
        NewPro.setPreco(dto.preco);

        Produto salvo = ServProd.SetProdut(NewPro);
        return ResponseEntity.ok(salvo);
    }

}
