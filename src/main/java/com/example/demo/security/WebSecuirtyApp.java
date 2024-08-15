
package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecuirtyApp {
	@Autowired
    private UserDetailsService userDetailsService;
 @Bean
     DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
 	@Bean
 	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
 		httpSecurity.csrf(AbstractHttpConfigurer::disable)
 		.cors(Customizer.withDefaults())
         .authorizeHttpRequests(auth ->
                 auth.requestMatchers("/index","/static/**").permitAll()
                .anyRequest()
                         .authenticated())

         
         .formLogin((formLogin) ->
         formLogin
         .defaultSuccessUrl("/add-student",true).permitAll()
 );
 return httpSecurity.build();
        
}
 
 /*@Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	 httpSecurity.csrf(AbstractHttpConfigurer::disable)
	 .cors(Customizer.withDefaults())
	         .authorizeHttpRequests(auth ->
	         
	                 auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll().requestMatchers("/index").permitAll()
	                .anyRequest()
	                         .authenticated())

             .formLogin(
                     form -> form
                             .loginPage("/login")
                             .defaultSuccessUrl("/home",true)
                             .permitAll()
     )
             .sessionManagement(session ->
             session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
     .httpBasic(Customizer.withDefaults());

     return httpSecurity.build();

        
    }*/


}
