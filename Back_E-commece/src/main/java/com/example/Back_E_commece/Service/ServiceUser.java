package com.example.Back_E_commece.Service;

import com.example.Back_E_commece.Model.Usuario;
import com.example.Back_E_commece.Repository.RepositoryUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    private final RepositoryUsers usersRepo;

    public ServiceUser(RepositoryUsers usersRepo) {
        this.usersRepo = usersRepo;
    }

    public List<Usuario> GetUsers()
    {
        return usersRepo.findAll();
    }



}
