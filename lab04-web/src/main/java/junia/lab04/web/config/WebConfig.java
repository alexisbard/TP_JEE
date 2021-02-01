package junia.lab04.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMVC
@Configuration
@ComponentScan(basePackages = "junia.lab04.web.controller")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
    @Bean
    public void VelocityConfigurer(){
        setResourceLoaderPath("/WEB-INF/velocity");
    }
    @Bean
    public void VelocityViewResolver(){

    }
}
