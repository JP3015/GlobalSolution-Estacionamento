package com.GS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        return http.build();
	}

    @Bean
    public InMemoryUserDetailsManager userDetailsService()  throws Exception {
        UserDetails user = User.withUsername("admin")
        .password("{bcrypt}$2a$12$nrp9sDgUH6I1.PKOqdKMHedXSrvCF17FJOMV///w3O4v3PZcCJtje")
        .roles("ADMIN")
        .build();
        return new InMemoryUserDetailsManager(user);
    }
   
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer()  throws Exception {
        return (web) -> web.ignoring().antMatchers("/materialize/**", "/style/**");
    }
    
}