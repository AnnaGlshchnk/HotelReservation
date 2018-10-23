package com.anna.entity;

public class Hotel {
        private Integer  hotelId;
        private String name;
        private  Integer roomId;

        public Hotel() {

        }

        public Hotel(String name) {
            this.name = name;
        }
        public Hotel(Integer hotelId, String name) {
            this.name = name;
            this.hotelId = hotelId;
        }

        public int getHotelId() {
            return hotelId;
        }

        public void setHotelId(Integer hotelId) {
            this.hotelId = hotelId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getRoomId() {
        return roomId;
    }

        public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }


}

