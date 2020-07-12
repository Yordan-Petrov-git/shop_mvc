package com.shop.advance.academy.yordan.petrov.git.shop.data.configuration;


import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.UserService;
import com.shop.advance.academy.yordan.petrov.git.shop.exeption.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final UserService userService;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public ApplicationSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserService userService, JwtRequestFilter jwtRequestFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.userService = userService;
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/user",  "/api/login").permitAll()
                .antMatchers( "/api/user",  "/api/login").anonymous()
                .antMatchers(HttpMethod.DELETE, "/api/items","/api/address","/api/contactinformation","/api/media","/api/opinion","/api/order").hasAnyAuthority("ROLE_USER")
                .antMatchers(HttpMethod.DELETE, "/api/user","api/city","api/country","api/card","api/transactions"
                        ,"/api/address","/api/currency","/api/contactinformation","/api/items","/api/media","/api/purchases","/api/seller","/api/cart").hasAnyAuthority( "ROLE_ADMIN" ,"ROLE_MODERATOR")
                .anyRequest().authenticated()
                .and().
                exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return username -> {
            try {
                UserDetails found = userService.loadUserByUsername(username);
                log.debug(">>> User authenticated for username: {} is {}", username, found);
                return found;
            } catch (EntityNotFoundException ex) {
                throw new UsernameNotFoundException(ex.getMessage(), ex);
            }
        };
    }

}

