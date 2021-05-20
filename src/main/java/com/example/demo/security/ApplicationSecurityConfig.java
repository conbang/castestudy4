package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ROLES.*;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(new JwtLoginAuthenticationFilter(authenticationManager()))
                .authorizeRequests()
//                .antMatchers("/", "/api/v1/shops/**")
//                .permitAll()
                .antMatchers("/api/v1/shops/register","/api/v1/shops/*/products")
                .hasRole(SHOP.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ana = User.builder()
                .username("anan")
                .password(passwordEncoder.encode("12345"))
                .roles(CUSTOMER.name())
                .build();
        UserDetails thanh = User.builder()
                .username("thanh")
                .password(passwordEncoder.encode("12345"))
                .roles(SHOP.name())
                .build();
        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("12345"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                ana,thanh,tom
        );
    }
}
