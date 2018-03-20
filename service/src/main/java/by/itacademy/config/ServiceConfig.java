package by.itacademy.config;

import by.itacademy.aspect.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"by.itacademy.service"})
@Import({CachingConfig.class})
public class ServiceConfig {

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

}
