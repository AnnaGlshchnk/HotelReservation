INSERT INTO hotel (hotel_id, hotel, room_id)
VALUES (1, 'Grand', 1),
       (2, 'Raffles', 2),
       (3, 'Burj al Arab', 3),
       (4, 'Martinez', 4);

INSERT INTO guest (guest_id, first_name, surname, reserv_id)
VALUES (1, 'Sam', 'Smit', 1),
       (2, 'Elisa', 'Petloy', 2),
       (3, 'Merry', 'Li', 3),
       (4, 'Jack', 'Jons', 4);

INSERT INTO reservation (reserv_id, start_reserv, end_reserv, room_id, guest_id)
VALUES (1, '9.10.2018',  '15.10.2018', 1, 1),
       (2, '15.11.2018',  '18.11.2018', 2, 2),
       (3, '16.05.2018',  '21.05.2018', 3, 3),
       (4, '27.10.2018',  '4.11.2018', 4, 4);

INSERT INTO room (room_id, price, hotel_id, reserv_id)
VALUES (1,  200, 1, 1),
       (2,  300, 2, 2),
       (3,  100, 3, 3),
       (4,  100, 4, 4);