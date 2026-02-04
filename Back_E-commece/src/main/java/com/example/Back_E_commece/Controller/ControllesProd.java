package com.example.Back_E_commece.Controller;


import com.example.Back_E_commece.Model.Produto;
import com.example.Back_E_commece.Service.ServiceProd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Prod")
public class ControllesProd {

    private final ServiceProd ServProd;

    public ControllesProd(ServiceProd servProd) {
        ServProd = servProd;
    }

    @RequestMapping("/")
    public String Teste()
    {
        return "Testando";
    }

    @GetMapping("/Produtos")
    public List<Produto> GetProd()
    {
        return ServProd.GetPro();

    }





}
