package com.example.Back_E_commece.Service;

import com.example.Back_E_commece.Model.Produto;
import com.example.Back_E_commece.Repository.RepositoryProd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProd {

private final RepositoryProd Repository;

    public ServiceProd(RepositoryProd repository) {
        Repository = repository;
    }

    public List<Produto> GetPro( )
    {
        return Repository.findAll();
    }

    public Produto SetProdut(Produto produto)
    {
        return Repository.save(produto);
    }

}
