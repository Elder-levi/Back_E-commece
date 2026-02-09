package com.example.Back_E_commece.Controller;

import com.example.Back_E_commece.Model.Usuario;
import com.example.Back_E_commece.Service.ServiceUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Usuarios")
public class ControllersUsers {

    private final ServiceUser ServUsers;

    public ControllersUsers(ServiceUser servUsers) {
        ServUsers = servUsers;
    }

    @GetMapping()
    public List<Usuario> GetUsuarios()
    {
        return ServUsers.GetUsers();
    }


}
