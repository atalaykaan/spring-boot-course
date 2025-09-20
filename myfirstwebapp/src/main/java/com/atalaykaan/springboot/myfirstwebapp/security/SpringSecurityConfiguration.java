package com.atalaykaan.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails userDetails1 = createUser("test", "deneme");
        UserDetails userDetails2 = createUser("Kaan", "123");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    private UserDetails createUser(String username, String password) {

        Function<String, String> encodeBcrypt = (input) -> passwordEncoder().encode(input);

        UserDetails tempUser = User.builder()
                .passwordEncoder(encodeBcrypt)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();

        return tempUser;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.formLogin(withDefaults());

        http.csrf().disable();

        http.headers().frameOptions().disable();

        return http.build();
    }
}
