package com.anna.entity;

public class Hotel {
        private Integer  hotelId;
        private String name;

        public Hotel() {

        }

        public Hotel(String name) {
            this.name = name;
        }
        public Hotel(Integer hotelId, String name) {
            this.name = name;
            this.hotelId = hotelId;
        }

        public int getId() {
            return hotelId;
        }

        public void setId(Integer hotelId) {
            this.hotelId = hotelId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

}

