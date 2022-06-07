package com.grupoBom.sistemaDiretor;

import com.grupoBom.sistemaDiretor.model.usuario.Usuario;
import com.grupoBom.sistemaDiretor.model.usuario.role.Role;
import com.grupoBom.sistemaDiretor.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SistemaDiretorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDiretorApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService){
		return args -> {
			usuarioService.saveRole(new Role(null, "ROLE_STUDENT"));
			usuarioService.saveRole(new Role(null, "ROLE_TEACHER"));
			usuarioService.saveRole(new Role(null, "ROLE_ADMIN"));

			usuarioService.saveUsuario(new Usuario(null, "Bruno Henrique", "brunoh", "123", new ArrayList<>()));
			usuarioService.saveUsuario(new Usuario(null, "Clara de Paula", "clarap", "345", new ArrayList<>()));
			usuarioService.saveUsuario(new Usuario(null, "Vanessa Silva", "vasilva", "678", new ArrayList<>()));

			usuarioService.addRoleToUsuario("brunoh", "ROLE_STUDENT");
			usuarioService.addRoleToUsuario("clarap", "ROLE_ADMIN");
			usuarioService.addRoleToUsuario("vasilva", "ROLE_TEACHER");
		};
	}
}
