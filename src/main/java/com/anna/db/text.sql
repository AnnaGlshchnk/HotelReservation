INSERT INTO guest (guest_id, first_name, surname)
VALUES (1, 'qaz', 'zaq'),
       (2, 'wss',  'xsw'),
       (3, 'den',    'dtd');

INSERT INTO hotel (hotel_id, hotel)
VALUES (1, 'Abc'),
       (2, 'Ter'),
       (3, 'Mir'),
       (4, 'Belarus');

INSERT INTO room (room_id, price, hotel_id)
VALUES (1, 4, 1),
       (2, 2, 2),
       (3, 3, 3);

INSERT INTO reservation (reserv_id, start_reserv, end_reserv, room_id, guest_id)
VALUES  (1, '31', '432', 1, 1),
        (2, '31', '432', 2, 2),
        (3, '31', '432', 3, 3),
        (4, '74', '2582', 1, 2);