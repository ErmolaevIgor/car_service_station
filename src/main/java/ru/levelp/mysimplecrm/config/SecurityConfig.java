package ru.levelp.mysimplecrm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.levelp.mysimplecrm.service.UserDetailsServiceImpl;

//@Configuration
//@EnableConfigurationProperties

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    public SecurityConfig() {
        super();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.
//                inMemoryAuthentication().
//                withUser("user").password("pass").
//                roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/signup", "/user/register").permitAll()
                .anyRequest().authenticated()

            .and().
                formLogin().
                loginPage("/login").permitAll().
                loginProcessingUrl("/doLogin")

            .and()
            .logout().permitAll().logoutUrl("/logout")

            .and()
            .csrf().disable()
        ;

    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http //+
//                .csrf().disable() //+
//                .formLogin().permitAll().and() //+
//                .authorizeRequests() //+
////                .anyRequest()
////                .authenticated()
////                .and().httpBasic()
////                .and().sessionManagement().disable();
//                .antMatchers("/").permitAll(); //+
//    }

}
