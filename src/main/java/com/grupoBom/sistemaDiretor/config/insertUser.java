package com.grupoBom.sistemaDiretor.config;

import com.grupoBom.sistemaDiretor.model.login.Usuario;
import com.grupoBom.sistemaDiretor.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class insertUser {

    

    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository){
        return args -> {
            //mockando usuario com:
            // username: diretor
            // senha: 123
            Usuario usuario = usuarioRepository.findUsuarioByUsername("diretor");
            
            Usuario admin = new Usuario(
                    "ADMIN",
                    "diretor",
                    "$2a$12$HBYMMPuKVLBZ0EPVEWDTeuh.8wgojBC1nQ9HNGWY.ByN4GuZo8uN6"
            );
            if (usuario == null) {
                usuarioRepository.save(admin);
            }
        };
    }
}
