-- ROLE
INSERT INTO `roles`(role_name) VALUES ('ADMIN');
INSERT INTO `roles`(role_name) VALUES ('CUSTOMER');
INSERT INTO `roles`(role_name) VALUES ('MEMBER');
INSERT INTO `roles`(role_name) VALUES ('EMPLOYEE');

-- ACCOUNT
INSERT INTO `account`(account_id, address, date_of_birth, email, full_name, gender, identity_card, image, password, phone_number, register_date, status, username, role_id) VALUES ('ACC0001', 'HaNoi', '1990-01-01', 'minh@gmail.com', 'Tong Cong Minh', 'male', '123456789', NULL, '$2a$10$Ei6prvGyuXo7zxom7J1RkeDBTszLj0VD2AjoqP28GedakJVDg5K/6', '0944444444', '2021-12-08', NULL, 'minh', '1');
INSERT INTO `account`(account_id, address, date_of_birth, email, full_name, gender, identity_card, image, password, phone_number, register_date, status, username, role_id) VALUES ('ACC0002', 'HCM', '1995-01-01', 'minh1@gmail.com', 'Tong Cong Minh1', 'male', '123456788', NULL, '$2a$10$yHQdTpzXwywtWJZ6dYnLDeCgDQcXLIg4N06ods4.EIW0Q11EeMdI.', '0911111111', '2021-12-08', NULL, 'minh1', '2');
INSERT INTO `account`(account_id, address, date_of_birth, email, full_name, gender, identity_card, image, password, phone_number, register_date, status, username, role_id) VALUES ('ACC0003', 'HN', '1992-01-01', 'minh2@gmail.com', 'Tong Cong Minh2', 'female', '123456787', NULL, '$2a$10$yHQdTpzXwywtWJZ6dYnLDeCgDQcXLIg4N06ods4.EIW0Q11EeMdI.', '0911111112', '2021-12-08', NULL, 'minh2', '3');
INSERT INTO `account`(account_id, address, date_of_birth, email, full_name, gender, identity_card, image, password, phone_number, register_date, status, username, role_id) VALUES ('ACC0004', 'HCM', '1995-03-01', 'minh3@gmail.com', 'Tong Cong Minh3', 'female', '123456786', NULL, '$2a$10$yHQdTpzXwywtWJZ6dYnLDeCgDQcXLIg4N06ods4.EIW0Q11EeMdI.', '0911111113', '2021-12-08', NULL, 'minh3', '4');

-- MEMBER
INSERT INTO `movie_theatre`.`member`(`member_id`,`score`,`account_id`) VALUES ('MEM0001',5,'ACC0003');

-- EMPLOYEE
INSERT INTO `movie_theatre`.`employee`(`employee_id`,`account_id`) VALUES ('EMP0001','ACC0004');

-- TICKET
INSERT INTO `movie_theatre`.`ticket`(`price`,`ticket_type`) VALUES(5,0);
INSERT INTO `movie_theatre`.`ticket`(`price`,`ticket_type`) VALUES(10,1);


-- INSERT INTO `movie_theatre`.`seat`(`seat_column`, `seat_row`, `seat_status`, `seat_type`, `cinema_room_id`) VALUES ('A', 1, 0, 0, 1);

INSERT INTO `movie_theatre`.`cinema_room`(`cinema_room_name`, `seat_quantity`) VALUES ('Room 1', 4);
INSERT INTO `movie_theatre`.`cinema_room`(`cinema_room_name`, `seat_quantity`) VALUES ('Room 2', 0);
INSERT INTO `movie_theatre`.`cinema_room`(`cinema_room_name`, `seat_quantity`) VALUES ('Room 3', 0);
INSERT INTO `movie_theatre`.`cinema_room`(`cinema_room_name`, `seat_quantity`) VALUES ('Room 4', 0);

INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Horror');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Action');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Romance');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Comedy');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Thriller');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Drama');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Science fiction');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Musical');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Documentary');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Western');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Fiction');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Animation');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('War');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Adventure');
INSERT INTO `movie_theatre`.`type`(type_name) VALUES ('Fantasy');

INSERT INTO movie_theatre.movie(movie_id, actor, cinema_room_id, content, director, duration, from_date, large_image, movie_name_english, movie_name_vn, movie_production_company, small_image, to_date, version) VALUES ('MOV0001', 'Timothée Chalamet, Rebecca Ferguson, Zendaya', 1, NULL, 'Denis Villeneuve', 156, '2021-12-01', NULL, 'Dune', 'DUNE: HÀNH TINH CÁT', NULL, NULL, '2022-03-01', NULL);

INSERT INTO movie_theatre.show_dates(show_date) VALUES ('2022-01-01');
INSERT INTO movie_theatre.show_dates(show_date) VALUES ('2022-29-12');

INSERT INTO movie_theatre.schedule(schedule_time) VALUES ('06:00:00');
INSERT INTO movie_theatre.schedule(schedule_time) VALUES ('09:00:00');
INSERT INTO movie_theatre.schedule(schedule_time) VALUES ('12:30:00');
INSERT INTO movie_theatre.schedule(schedule_time) VALUES ('18:00:00');

INSERT INTO movie_theatre.movie_date(movie_id, show_date_id) VALUES ('MOV0001', 1);
INSERT INTO movie_theatre.movie_date(movie_id, show_date_id) VALUES ('MOV0001', 7);

INSERT INTO movie_theatre.movie_schedule(movie_id, schedule_id) VALUES ('MOV0001', 1);
INSERT INTO movie_theatre.movie_schedule(movie_id, schedule_id) VALUES ('MOV0001', 3);

INSERT INTO movie_theatre.movie_type(movie_id, type_id) VALUES ('MOV0001', 2);
INSERT INTO movie_theatre.movie_type(movie_id, type_id) VALUES ('MOV0001', 3);
INSERT INTO movie_theatre.movie_type(movie_id, type_id) VALUES ('MOV0001', 14);

INSERT INTO movie_theatre.seat(seat_column, seat_row, seat_status, seat_type, cinema_room_id) VALUES ('A', 1, 0, 0, 1);
INSERT INTO movie_theatre.seat(seat_column, seat_row, seat_status, seat_type, cinema_room_id) VALUES ('B', 1, 0, 0, 1);

INSERT INTO movie_theatre.schedule_seat(schedule_seat_id, movie_id, schedule_id, seat_column, seat_id, seat_row, seat_status, seat_type, show_date_id) VALUES ('SS0001', 'MOV0001', 1, NULL, 1, NULL, 0, 0, 1);
INSERT INTO movie_theatre.schedule_seat(schedule_seat_id, movie_id, schedule_id, seat_column, seat_id, seat_row, seat_status, seat_type, show_date_id) VALUES ('SS0002', 'MOV0001', 1, NULL, 2, NULL, 0, 1, 1);
# INSERT INTO movie_theatre.test(name) VALUES ('test name 1');

