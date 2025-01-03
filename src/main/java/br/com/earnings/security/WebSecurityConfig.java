package br.com.earnings.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf->{
            csrf.disable(); //desabilita a tela de login
        }).authorizeHttpRequests(auth ->{
            auth.requestMatchers(new AntPathRequestMatcher("/categoria","GET")).permitAll() //caminho liberado
                    .requestMatchers(new AntPathRequestMatcher("/auth/login","POST")).permitAll()
                    .anyRequest().authenticated();
        }).addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
