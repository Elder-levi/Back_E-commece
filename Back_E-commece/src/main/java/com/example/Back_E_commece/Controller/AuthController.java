package com.example.Back_E_commece.Controller;

import com.example.Back_E_commece.Model.DTO.LoginDTO;
import com.example.Back_E_commece.Model.Usuario;
import com.example.Back_E_commece.Service.AuthService;
import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/V1/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/Registrar")
    public void register(@RequestBody @Validated Usuario usuario) throws Exception
  {
      authService.registrer(usuario);
  }

    @PostMapping("/Login")
    public void Login(@RequestBody @Validated LoginDTO login) throws Exception
    {
        authService.login(login);
    }



}
