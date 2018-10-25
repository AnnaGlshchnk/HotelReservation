INSERT INTO hotel (hotel_id, hotel, room_id)
VALUES (1, 'Grand', 1),
       (2, 'Raffles', 2),
       (3, 'Burj al Arab', 3),
       (4, 'Martinez', 4);

INSERT INTO rooms (room_id, price, hotel_id, reserv_id)
VALUES (1,  200, 1, 1),
       (2,  300, 2, 2),
       (3,  100, 3, 3),
       (4,  100, 4, 4);

INSERT INTO guests (guest_id, first_name, surname, reserv_id)
VALUES (1, 'Sam', 'Smit', 1),
       (2, 'Elisa', 'Petloy', 2),
       (3, 'Merry', 'Li', 3),
       (4, 'Jack', 'Jons', 4);

INSERT INTO reservation (reserv_id, start_reserv, end_reserv, room_id, guest_id)
VALUES (1, 2018-09-1,  2018-09-6, 1, 1),
       (2, 2018-09-15,  2018-09-18, 3, 2),
       (3, 2018-08-1,  2018-08-6, 2, 3),
       (4, 2018-07-1,  2018-07-15, 4, 4);
