package net.codejava;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
     
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("namhm")
               // .password("$2a$10$PrZnT9ln97nGkf3cfq./r.nQGs7PZ9Hc1GAdcbhfS2nXjVfJJbjYq")
                .password("{noop}password")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("admin")
               // .password("$2a$10$PrZnT9ln97nGkf3cfq./r.nQGs7PZ9Hc1GAdcbhfS2nXjVfJJbjYq")
                .password("{noop}password")
                .roles("ADMIN")
                .build();      
         
        return new InMemoryUserDetailsManager(user1, user2);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().antMatchers("/", "/home").permitAll()
            .antMatchers("/welcome").hasAnyRole("USER","ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")       
                .usernameParameter("u").passwordParameter("p")             
                .permitAll()
             .and()
              .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
 
}