package com.medical.management.system.medical.management.config;

import com.medical.management.system.medical.management.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers( "/pharmacy/add/DetailsOfUser").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pharmacy/authenticate").permitAll()

                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AllAdmins").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AllEmployees").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AllMedicines").hasAnyRole("ADMIN", "EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AllRestocks").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AllSales").hasAnyRole("ADMIN", "EMPLOYEE")

                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AdminById/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/EmployeeById/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/MedicineById/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/RestockById/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/SalesById/**").hasAnyRole("ADMIN","EMPLOYEE")

                .requestMatchers(HttpMethod.GET, "/pharmacy/display/AdminByName/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/EmployeeByName/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/display/MedicineByName/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pharmacy/invoice/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/reports/**").permitAll()



                .requestMatchers(HttpMethod.POST, "/pharmacy/add/**").hasRole("ADMIN")
                .requestMatchers( HttpMethod.PUT,"/pharmacy/update/**").hasRole("ADMIN")
                .requestMatchers( HttpMethod.DELETE,"/pharmacy/delete/**").hasRole("ADMIN")


                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
