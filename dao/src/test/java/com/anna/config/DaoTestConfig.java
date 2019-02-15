package com.anna.config;

import com.anna.dao.*;
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
public class DaoTestConfig {

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
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public GuestDao guestDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new GuestDaoImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public HotelDao hotelDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new HotelDaoImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public RoomDao roomDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new RoomDaoImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public ReservationDao reservationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new ReservationDaoImpl(namedParameterJdbcTemplate);
    }
}
