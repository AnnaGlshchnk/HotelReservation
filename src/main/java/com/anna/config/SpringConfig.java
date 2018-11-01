package com.anna.config;


import com.anna.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTesBean(){
        return new TestBean("hello");
    }
}
