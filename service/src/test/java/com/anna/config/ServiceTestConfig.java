package com.anna.config;

import com.anna.dao.api.GuestDao;
import com.anna.dao.api.HotelDao;
import com.anna.dao.api.ReservationDao;
import com.anna.dao.api.RoomDao;
import com.anna.dao.impl.GuestDaoImpl;
import com.anna.dao.impl.HotelDaoImpl;
import com.anna.dao.impl.ReservationDaoImpl;
import com.anna.dao.impl.RoomDaoImpl;
import com.anna.service.api.GuestService;
import com.anna.service.api.HotelService;
import com.anna.service.api.ReservationService;
import com.anna.service.api.RoomService;
import com.anna.service.impl.GuestServiceImpl;
import com.anna.service.impl.HotelServiceImpl;
import com.anna.service.impl.ReservationServiceImpl;
import com.anna.service.impl.RoomServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:sql.properties")
@EnableTransactionManagement
public class ServiceTestConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db_scheme_test.sql")
                .addScript("db_data_test.sql")
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public GuestDao guestDao() {
        return new GuestDaoImpl(namedParameterJdbcTemplate());
    }

    @Bean
    public GuestService guestService() {
        return new GuestServiceImpl(guestDao());
    }

    @Bean
    public HotelDao hotelDao(){
        return  new HotelDaoImpl(namedParameterJdbcTemplate());
    }

    @Bean
    public HotelService hotelService(){
        return  new HotelServiceImpl(hotelDao());
    }

    @Bean
    public ReservationDao reservationDao(){
        return  new ReservationDaoImpl(namedParameterJdbcTemplate());
    }

    @Bean
    public ReservationService reservationService() {
        return new ReservationServiceImpl(reservationDao());
    }

    @Bean
    public RoomDao roomDao(){
        return  new RoomDaoImpl(namedParameterJdbcTemplate());
    }

    @Bean
    public RoomService roomService() {
        return new RoomServiceImpl(roomDao());
    }

}
