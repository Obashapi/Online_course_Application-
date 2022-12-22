package com.example.spring.boot.microservice.course1.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Value("${service.security.secure-key-username}")
  private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth)throws Exception{

        PasswordEncoder encoder=new BCryptPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("user")
                .password(encoder.encode("password"))
                .roles("USER");




    }

}
