package com.example.lab6_sol.config;

import com.example.lab6_sol.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class Configuraciones {
/*
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    DataSource dataSource;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/processLogin")
                .usernameParameter("email")
                .passwordParameter("contrasenia")
                .successHandler((request, response, authentication) -> {

                    HttpSession session = request.getSession();
                    session.setAttribute("usuario",usuarioRepository.findByEmail(authentication.getName()));

                    String rol = "";
                    for(GrantedAuthority role : authentication.getAuthorities()){
                        rol = role.getAuthority();
                        break;
                    }

                    if(rol.equals("Estudiante")){
                        response.sendRedirect("/estudiantes");
                    }else{
                        response.sendRedirect("/cursos");
                    }
                    if(rol.equals("Profesor")){
                        response.sendRedirect("/estudiantes");
                    }else{
                        response.sendRedirect("/cursos");
                    }
                    if(rol.equals("Administrador")){
                        response.sendRedirect("/estudiantes");
                    }else{
                        response.sendRedirect("/cursos");
                    }

                });

        http.authorizeHttpRequests()
                .requestMatchers("/employee", "/employee/**").hasAnyAuthority("admin", "logistica")
                .requestMatchers("/shipper", "/shipper/**").hasAuthority("admin")
                .anyRequest().permitAll();

        http.logout().logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);

        String sql1 = "SELECT email,pwd,activo FROM usuario where email = ?";
        String sql2 = "SELECT u.email, r.nombre FROM usuario u INNER JOIN rol r ON (u.idrol = r.idrol) " +
                "WHERE u.email = ?";

        jdbc.setUsersByUsernameQuery(sql1);
        jdbc.setAuthoritiesByUsernameQuery(sql2);
        return jdbc;
    }

    */
}
