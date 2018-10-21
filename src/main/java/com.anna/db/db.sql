DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel(
  hotel_id            INT              NOT NULL AUTO_INCREMENT,
  hotel               VARCHAR(255)     NOT NULL UNIQUE,
  room_id             INT              NOT NULL,
  PRIMARY KEY (hotel_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)  ON DELETE CASCADE
);

DROP TABLE IF EXISTS rooms;
CREATE TABLE rooms(
  room_id      INT              NOT NULL AUTO_INCREMENT,
  price        INT              NOT NULL,
  hotel_id     INT              NOT NULL,
  reserv_id    INT              NOT NULL,
  PRIMARY KEY (room_id),
  FOREIGN KEY (reserv_id) REFERENCES reservation(reserv_id)  ON DELETE CASCADE);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation(
  reserv_id       INT            NOT NULL AUTO_INCREMENT,
  start_reserv    DATE           NOT NULL,
  end_reserv      DATE           NOT NULL,
  room_id         INT            NOT NULL,
  guest_id        INT            NOT NULL
  PRIMARY KEY (reserv_id),
  FOREIGN KEY (guest_id) REFERENCES guests(guest_id)  ON DELETE CASCADE,
);

DROP TABLE IF EXISTS guests;
CREATE TABLE guests (
  guest_id       INT            NOT NULL AUTO_INCREMENT,
  first_name     VARCHAR(255)   NOT NULL,
  surname        VARCHAR(255)   NOT NULL,
  PRIMARY KEY (guest_id);


