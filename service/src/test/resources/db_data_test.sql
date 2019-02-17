INSERT INTO guest (guest_id, first_name, surname)
VALUES (1, 'Klaus', 'Schmidt'),
       (2, 'Hilary',  'Willis'),
       (3, 'Ashlie',  'Goodwin'),
       (4, 'Randell',  'Fox');

INSERT INTO hotel (hotel_id, hotel_name)
VALUES (1, 'Hilton'),
       (2, 'Grand_Hotel'),
       (3, 'Plaza');

INSERT INTO room (room_id, room_number, hotel_id)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 1, 2),
       (4, 2, 2),
       (5, 1, 3),
       (6, 2, 3);

INSERT INTO reservation (reservation_id, start_reservation, end_reservation, room_id, guest_id)
VALUES  (1, '2018-07-12', '2018-07-16', 1, 1),
        (2, '2019-01-04', '2019-01-10', 2, 2),
        (3, '2018-08-19', '2018-08-29', 3, 3),
        (4, '2019-02-06', '2019-02-10', 4, 4);