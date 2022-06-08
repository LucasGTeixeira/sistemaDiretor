package com.grupoBom.sistemaDiretor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").hasAuthority("ADMIN")
                .antMatchers("/professores/listarProfessores").hasAuthority("ADMIN")
                .antMatchers("/professores/new").hasAuthority("ADMIN")
                .antMatchers("/professores/save").hasAuthority("ADMIN")
                .antMatchers("/professores/save").hasAuthority("ADMIN")
                .antMatchers("/professores/show/{id}").hasAuthority("ADMIN")
                .antMatchers("/professores/{id}/edit").hasAuthority("ADMIN")
                .antMatchers("/professores/{id}/delete").hasAuthority("ADMIN")

                .antMatchers("/alunos/listarAlunos").hasAuthority("ADMIN")
                .antMatchers("/alunos/new").hasAuthority("ADMIN")
                .antMatchers("/alunos/save").hasAuthority("ADMIN")
                .antMatchers("/alunos/save").hasAuthority("ADMIN")
                .antMatchers("/alunos/show/{id}").hasAuthority("ADMIN")
                .antMatchers("/alunos/{id}/edit").hasAuthority("ADMIN")
                .antMatchers("/alunos/{id}/delete").hasAuthority("ADMIN")

                .antMatchers("/cursos/listarCursos").hasAuthority("ADMIN")
                .antMatchers("/cursos/new").hasAuthority("ADMIN")
                .antMatchers("/cursos/save").hasAuthority("ADMIN")
                .antMatchers("/cursos/save").hasAuthority("ADMIN")
                .antMatchers("/cursos/show/{id}").hasAuthority("ADMIN")
                .antMatchers("/cursos/{id}/edit").hasAuthority("ADMIN")
                .antMatchers("/cursos/{id}/delete").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
