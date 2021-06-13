package net.codejava;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/login").setViewName("login");
    }
 
}