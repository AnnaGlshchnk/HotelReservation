package com.anna.config;

import com.anna.service.HotelReservationService;
import com.anna.service.HotelReservationServiceImpl;
import com.anna.dao.HotelReservationDao;
import com.anna.dao.HotelReservationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:sql.properties")
public class TestConfig {

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create.sql")
                .addScript("data.sql")
                .build();
    }

    @Bean
    public HotelReservationDao getHotelReservationDao(){
        return new HotelReservationImpl(getJdbcTemplate());
    }

    @Bean
    public HotelReservationService getHotelReservationService(){
        return new HotelReservationServiceImpl(getHotelReservationDao());
    }
}
