package com.example.Back_E_commece.Service;

import com.example.Back_E_commece.Config.SecurityConfig.TokenProvider;
import com.example.Back_E_commece.Config.SecurityConfig.securityConfiguration;
import com.example.Back_E_commece.Model.DTO.LoginDTO;
import com.example.Back_E_commece.Model.DTO.TokenDTO;
import com.example.Back_E_commece.Model.Enum.Roles;
import com.example.Back_E_commece.Model.Usuario;
import com.example.Back_E_commece.Repository.RepositoryUsers;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Value("${api.security.token.expiration}")
    private long expirationTime;
    private final AuthenticationManager authenticationManager;
private  final RepositoryUsers repositoryUsers;
private final securityConfiguration securityConfiguration;
private  final TokenProvider tokenProvider;
    public AuthService(AuthenticationManager authenticationManager, RepositoryUsers repositoryUsers, securityConfiguration securityConfiguration, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.repositoryUsers = repositoryUsers;
        this.securityConfiguration = securityConfiguration;
        this.tokenProvider = tokenProvider;
    }

    public void registrer (Usuario usuario)
throws BadRequestException
{
    Usuario user = repositoryUsers.findByEmail(usuario.getEmail())
            .orElse(null);
     if (user != null)
     {
         throw new BadRequestException("Usuario ja cadastrado");
     }
     usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuario.getSenha()));
     usuario.setPermicoes(Roles.ROLE_USER);
     repositoryUsers.save(usuario);

}

public TokenDTO login (LoginDTO dto) throws Exception
{
    try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha()));
      String token = tokenProvider.GeraToken(authentication);
      return new TokenDTO( token , expirationTime);
    }catch (BadCredentialsException e)
    {
      throw  new BadRequestException("Credenciais Invalidas!!!");
    }
    catch (Exception e)
    {
        throw e;
    }
}

}
