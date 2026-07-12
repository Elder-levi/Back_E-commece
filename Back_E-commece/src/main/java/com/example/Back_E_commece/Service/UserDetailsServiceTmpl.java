package com.example.Back_E_commece.Service;

import com.example.Back_E_commece.Model.Usuario;
import com.example.Back_E_commece.Repository.RepositoryUsers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceTmpl implements UserDetailsService {

    private final RepositoryUsers repositoryUsers;

    public UserDetailsServiceTmpl(RepositoryUsers repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUsers.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
