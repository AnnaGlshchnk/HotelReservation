DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS guest;

CREATE TABLE guest(
  guest_id               INT             NOT NULL       AUTO_INCREMENT,
  first_name             VARCHAR(20)     NOT NULL,
  surname                VARCHAR(20)     NOT NULL,
  PRIMARY KEY (guest_id));

CREATE TABLE hotel(
  hotel_id               INT             NOT NULL       AUTO_INCREMENT,
  hotel_name             VARCHAR(30)     NOT NULL       UNIQUE,
  PRIMARY KEY (hotel_id));

CREATE TABLE room(
  room_id                INT              NOT NULL      AUTO_INCREMENT,
  room_number            INT              NOT NULL,
  hotel_id               INT              NOT NULL,
  PRIMARY KEY (room_id),
  FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)  ON DELETE CASCADE);


CREATE TABLE reservation(
  reservation_id          INT            NOT NULL       AUTO_INCREMENT,
  start_reservation       DATE           NOT NULL,
  end_reservation         DATE           NOT NULL,
  room_id                 INT            NOT NULL,
  guest_id                INT            NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (room_id)  REFERENCES room(room_id)    ON DELETE CASCADE,
  FOREIGN KEY (guest_id) REFERENCES guest(guest_id)  ON DELETE CASCADE
);