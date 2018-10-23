DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel(
  hotel_id            INT              NOT NULL AUTO_INCREMENT,
  hotel               VARCHAR(255)     NOT NULL UNIQUE,
  room_id             INT              NOT NULL,
  PRIMARY KEY (hotel_id),
  FOREIGN KEY (room_id) REFERENCES room(room_id)  ON DELETE CASCADE
);

DROP TABLE IF EXISTS room;
CREATE TABLE room(
  room_id      INT              NOT NULL AUTO_INCREMENT,
  price        INT              NOT NULL,
  hotel_id     INT              NOT NULL,
  reserv_id    INT              NOT NULL,
  PRIMARY KEY (room_id),
  FOREIGN KEY (reserv_id) REFERENCES reservation(reserv_id)  ON DELETE CASCADE);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation(
  reserv_id       INT            NOT NULL AUTO_INCREMENT,
  start_reserv    VARCHAR (15)          NOT NULL,
  end_reserv      VARCHAR (15)          NOT NULL,
  room_id         INT            NOT NULL,
  guest_id       INT            NOT NULL,
  PRIMARY KEY (reserv_id)
);

DROP TABLE IF EXISTS guests;
CREATE TABLE guests (
  guest_id       INT            NOT NULL AUTO_INCREMENT,
  first_name     VARCHAR(255)   NOT NULL,
  surname        VARCHAR(255)   NOT NULL,
  reserv_id       INT            NOT NULL,
  PRIMARY KEY (guest_id),
  FOREIGN KEY (reserv_id) REFERENCES reservation(reserv_id)  ON DELETE CASCADE);


