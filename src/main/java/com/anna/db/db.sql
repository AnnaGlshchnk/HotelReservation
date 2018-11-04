DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS guest;
DROP TABLE IF EXISTS hotel;

CREATE TABLE guest (
  guest_id       INT            NOT NULL AUTO_INCREMENT,
  first_name     VARCHAR(255)   NOT NULL,
  surname        VARCHAR(255)   NOT NULL,
  PRIMARY KEY (guest_id));

CREATE TABLE hotel(
  hotel_id            INT              NOT NULL AUTO_INCREMENT,
  hotel               VARCHAR(255)     NOT NULL UNIQUE,
  PRIMARY KEY (hotel_id));

CREATE TABLE room(
  room_id      INT              NOT NULL AUTO_INCREMENT,
  price        INT              NOT NULL,
  hotel_id     INT              NOT NULL,
  reserv_id    INT              NOT NULL,
  PRIMARY KEY (room_id),
  FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)  ON DELETE CASCADE);


CREATE TABLE reservation(
  reserv_id       INT            NOT NULL AUTO_INCREMENT,
  start_reserv    VARCHAR (15)          NOT NULL,
  end_reserv      VARCHAR (15)          NOT NULL,
  room_id         INT            NOT NULL,
  guest_id       INT            NOT NULL,
  PRIMARY KEY (reserv_id),
  FOREIGN KEY (room_id) REFERENCES room(room_id)  ON DELETE CASCADE,
  FOREIGN KEY (guest_id) REFERENCES guest(guest_id)  ON DELETE CASCADE
);