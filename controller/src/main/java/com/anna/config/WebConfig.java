package com.anna.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.anna.dao", "com.anna.service", "com.anna.aspect", "com.anna.controller"})
@EnableWebMvc
@Import({DaoConfig.class})
@EnableAspectJAutoProxy
public class WebConfig {
}
