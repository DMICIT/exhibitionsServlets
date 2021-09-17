INSERT INTO themes (theme)
VALUES ('Автомобили'),
       ('рыбалка и охота'),
       ('коты и собаки');
INSERT INTO exhibitions (id_theme, start_date, end_date, start_time, end_time, entry_cost, status)
VALUES ('1', '2020-06-01', '2020-06-21', '10:00', '18:00', '800', 'expected'),
       ('2', '2020-06-24', '2020-07-07', '10:00', '18:00', '500', 'expected'),
       ('3', '2020-07-10', '2020-07-24', '10:00', '18:00', '500', 'expected'),
       ('1', '2020-08-01', '2020-08-14', '10:00', '18:00', '300', 'expected'),
       ('3', '2020-08-15', '2020-08-30', '10:00', '18:00', '300', 'expected');
INSERT INTO areas (area)
VALUES ('1'),
       ('2');
INSERT INTO exhibition_areas(id_area, id_exhibition)
VALUES ('1', '1'),
       ('2', '1'),
       ('1', '2'),
       ('2', '3'),
       ('1', '4'),
       ('2', '5');

INSERT INTO users (name, email, password, role)
VALUES ('Ivan', 'ivan@gmail.com', '12345', 'admin'),
       ('Alex', 'alex@gmail.com', '123456', 'user'),
       ('Max', 'max@gmail.com', 1234, 'annonimous');

INSERT INTO tickets (id_exhibition, id_user, sold_date)
VALUES ('1', '1', '2020-11-11 11:11:15'),
       ('1', '2','2020-10-11 12:11:16'),
       ('1', '3','2020-9-11 13:11:17'),
       ('2', '3','2020-4-11 14:11:18'),
       ('3', '1','2020-5-11 15:11:19'),
       ('4', '2','2020-6-11 16:11:10');
