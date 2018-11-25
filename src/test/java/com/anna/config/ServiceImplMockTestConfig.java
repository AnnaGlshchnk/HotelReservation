package com.anna.config;

import com.anna.service.HotelReservationService;
import com.anna.service.HotelReservationServiceImpl;
import com.anna.test.HotelReservationDao;
import com.anna.test.HotelReservationImpl;
import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceImplMockTestConfig {

    @Bean
    public HotelReservationDao hotelReservationDao(){
        return EasyMock.createMock(HotelReservationImpl.class);
    }

    @Bean
    public HotelReservationService hotelReservationService(){
        return new HotelReservationServiceImpl(hotelReservationDao());
    }
}
