package flightsProject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((authorize) ->
                authorize
                        .requestMatchers(toH2Console()).permitAll() //allow H2Console and other requests need authenticate
                        .anyRequest().authenticated())
                .csrf((csrf)-> csrf.disable()) // disable CSRF(cross-site request forgery protection
                .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin())) // important to managing the frames
                .httpBasic(Customizer.withDefaults()) // activates simple authenticaion process with username and pass
                .formLogin(Customizer.withDefaults()); // configures form based authentication
        return httpSecurity.build();
    }
}
