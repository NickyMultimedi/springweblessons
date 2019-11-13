package be.multimedi.weblessons;

import org.springframework.beans.factory.annotation.Autowired;
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

import javax.sql.DataSource;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebApplication {
    private static final String USERNAME_QUERY = "select name, passwordbc, enabled from Users where name = ?";
    private static final String AUTHORITIES_QUERY = "select name, role from Users where name = ?";

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

    @Autowired
    public void configureSecurity(AuthenticationManagerBuilder auth, DataSource ds) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(ds)
                .usersByUsernameQuery(USERNAME_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY);
    }

    @Bean
    public WebSecurityConfigurer<WebSecurity> securityConfigurer() {
        return new WebSecurityConfigurerAdapter() {
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
