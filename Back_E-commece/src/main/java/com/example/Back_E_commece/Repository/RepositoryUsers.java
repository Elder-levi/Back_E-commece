package com.example.Back_E_commece.Repository;

import com.example.Back_E_commece.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsers extends JpaRepository<Usuario ,Long> {

}
