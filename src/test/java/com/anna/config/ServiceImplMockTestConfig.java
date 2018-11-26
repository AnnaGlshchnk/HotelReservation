package com.anna.config;

import com.anna.service.HotelReservationService;
import com.anna.service.HotelReservationServiceImpl;
import com.anna.dao.HotelReservationDao;
import com.anna.dao.HotelReservationImpl;
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
