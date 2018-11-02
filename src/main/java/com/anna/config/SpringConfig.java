package com.anna.config;


import com.anna.dao.HotelReservationDao;
import com.anna.dao.HotelReservationImpl;
import com.anna.service.HotelReservationService;
import com.anna.service.HotelReservationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.anna.service", "com.anna.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/hotel?useSll=false");
        dataSource.setUsername("qwer");
        dataSource.setPassword("123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }


}
