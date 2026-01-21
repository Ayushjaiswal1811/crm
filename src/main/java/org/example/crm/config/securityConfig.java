package org.example.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class securityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder().username("admin").password("$2a$12$RjIqutdkeJkWrXveONmTaewVNXK1WbM7Gn20qiJ3ft4KTMzgX/TUy").build();
//        return new InMemoryUserDetailsManager(user);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf( csrf->csrf.disable())
                .authorizeHttpRequests(auth ->auth.requestMatchers("/public/**","/","/public")
                        .permitAll().requestMatchers("/admin/**").authenticated().anyRequest().authenticated())
                .formLogin(Customizer.withDefaults()).logout(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
