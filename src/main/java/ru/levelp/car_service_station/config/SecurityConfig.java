package ru.levelp.car_service_station.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .mvcMatchers("/customers", "/customer_cars", "/").authenticated()

                .and()
                    .formLogin().permitAll()

                .and()
                    .httpBasic()

                .and()
                    .csrf().disable()
        ;
    }

}
