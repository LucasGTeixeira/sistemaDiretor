package com.grupoBom.sistemaDiretor.security;

import com.grupoBom.sistemaDiretor.model.login.Usuario;
import com.grupoBom.sistemaDiretor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findUsuarioByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("username não corresponde a nenhum usuario");
        }
        return new CustomUserDetails(usuario);
    }
}
