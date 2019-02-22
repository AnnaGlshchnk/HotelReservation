package com.anna.dao.impl;

import com.anna.dao.api.RoomDao;
import com.anna.model.Hotel;
import com.anna.model.Room;
import com.anna.model.RoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    private static String ROOM_ID = "roomId";

    @Value("${hotelreservation.getRooms}")
    private String getRoomsSql;
    @Value("${hotelreservation.getRoomById}")
    private String getRoomByIdSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RoomDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<RoomDetails> getRooms() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(getRoomsSql, mapSqlParameterSource, new RoomMapper());
    }

    public RoomDetails getRoomById(Integer roomId) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(ROOM_ID, roomId);
        return namedParameterJdbcTemplate.queryForObject(getRoomByIdSql, mapSqlParameterSource, new RoomMapper());
    }

    private class RoomMapper implements RowMapper<RoomDetails> {
        @Override
        public RoomDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new RoomDetails(rs.getLong("room_id"),
                    new Room(rs.getInt("room_number")),
                    new Hotel(rs.getString("hotel_name")));
        }
    }


}
