package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.model.usuario.Usuario;
import com.grupoBom.sistemaDiretor.model.usuario.role.Role;
import com.grupoBom.sistemaDiretor.service.UsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<Usuario>>getUsuarios(){
        return ResponseEntity.ok().body(usuarioService.getUsuarios());
    }

    @PostMapping("/saveUsuario")
    public ResponseEntity<Usuario>saveUsuario(@RequestBody Usuario usuario){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/saveUsuario").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveUsuario(usuario));
    }

    @PostMapping("/saveRole")
    public ResponseEntity<Role>saveUsuario(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/saveRole").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveRole(role));
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<?>addRoleToUsuario(@RequestBody RoleToUserForm form){
        usuarioService.addRoleToUsuario(form.getUsername(), form.getNomeRole());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String username;
    private String nomeRole;
}
