package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.usuario.Usuario;
import com.grupoBom.sistemaDiretor.model.usuario.role.Role;
import com.grupoBom.sistemaDiretor.repository.UsuarioRepository;
import com.grupoBom.sistemaDiretor.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null){
            log.error("Usuário não encontrado no banco de dados");
            throw new UsernameNotFoundException("Usuário não emcontrado no sistema");
        }
        log.info("Usuário encontrado");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getNome())));
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getSenha(), authorities);
    }

    public Usuario saveUsuario(Usuario usuario){
        log.info("Salvando novo Usuario {} no banco de dados", usuario.getNome());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Role saveRole(Role role){
        log.info("Salvando nova Role {} no banco de dados", role.getNome());
        return roleRepository.save(role);
    }

    public void addRoleToUsuario(String username, String nomeRole){
        log.info("Salvando nova Role {} para o usuario {}", nomeRole, username);
        Usuario usuario = usuarioRepository.findByUsername(username);
        Role role = roleRepository.findByNome(nomeRole);
        usuario.getRoles().add(role);
    }

    public Usuario getUsuario(String username){
        log.info("Buscando Usuario {} no banco de dados", username);
        return usuarioRepository.findByUsername(username);
    }

    public List<Usuario> getUsuarios(){
        log.info("");
        return usuarioRepository.findAll();
    }
}
