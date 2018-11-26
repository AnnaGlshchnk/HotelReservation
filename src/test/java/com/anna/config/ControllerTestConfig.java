package com.anna.config;

import com.anna.controller.HotelReservationController;
import com.anna.service.HotelReservationService;
import com.anna.service.HotelReservationServiceImpl;
import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.anna.*")
public class ControllerTestConfig {

    @Bean
    public HotelReservationService hotelReservationService(){
        return EasyMock.createMock(HotelReservationService.class);
    }
}
