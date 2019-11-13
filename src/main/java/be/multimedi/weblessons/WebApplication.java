package be.multimedi.weblessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebApplication {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("welcome")
                        .setViewName("welcome");
            }
        };
    }

    @Bean
    public WebSecurityConfigurer<WebSecurity> securityConfigurer() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.inMemoryAuthentication()
                        .passwordEncoder(new BCryptPasswordEncoder())
                        .withUser("Nick")
                        .password("$2a$10$6ijNwwL19abb5t/kD2AqLeMYi8/fNuldNSSrU9h6CLHEhAWW6IB.S")
                        .roles("ADULT")
                        .and()
                        .withUser("Mitch")
                        .password("$2a$10$6ijNwwL19abb5t/kD2AqLeMYi8/fNuldNSSrU9h6CLHEhAWW6IB.S")
                        .roles("ANIMAL");
            }

            @Override
            protected void configure(HttpSecurity http) throws Exception {
//                    http.httpBasic();
                http.formLogin();
                    http.csrf().disable();
                    http.authorizeRequests()
                            .antMatchers("/security/**")
                            .hasRole("ADULT");
            }
        };
    }
}
