package com.example.Back_E_commece.Repository;

import com.example.Back_E_commece.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProd extends JpaRepository<Produto ,Long> {
}
