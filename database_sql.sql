create table bills (id bigint not null auto_increment, final_cost int not null, pay_datetime datetime, primary key (id));
create table chats (id bigint not null auto_increment, primary key (id));
create table cost_strategies (id bigint not null auto_increment, strategy varchar(80) not null, primary key (id));
create table reservation_statuses (id bigint not null auto_increment, status_name varchar(30) not null unique, primary key (id));
create table roles (id bigint not null auto_increment, role_name varchar(30) not null unique, primary key (id));
create table users (id bigint not null auto_increment, login varchar(40) not null unique, password varchar(40) not null, primary key (id));
create table chat_lines (id bigint not null auto_increment, line_text varchar(255), date_time datetime, chat_id bigint not null, user_id bigint not null, primary key (id), foreign key (chat_id) references chats (id), foreign key (user_id) references users (id));
create table vehicle_categories (id bigint not null auto_increment, category_name varchar(30) not null unique, category_cost_strategy_id bigint not null unique, primary key (id), foreign key (category_cost_strategy_id) references cost_strategies (id));
create table users_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id), foreign key (role_id) references roles (id), foreign key (user_id) references users (id));
create table additional_users_info (id bigint not null auto_increment, driving_licence_info varchar(255) not null unique, passport_info varchar(255) not null unique, user_id bigint not null unique, primary key (id), foreign key (user_id) references users (id));
create table reviews (id bigint not null auto_increment, commend_text varchar(255) not null, datetime_commend datetime, user_id bigint not null, primary key (id), foreign key (user_id) references users (id));
create table additional_reviews (id bigint not null auto_increment, commend_text varchar(255) not null, datetime_commend datetime, review_id bigint not null unique, primary key (id), foreign key (review_id) references reviews (id));
create table vehicles (id bigint not null auto_increment, cubic_capacity int not null, manufacture varchar(30) not null, model varchar(30) not null, power_ int not null, stanadart_price int not null, year int not null, category_id bigint not null, primary key (id), foreign key (category_id) references vehicle_categories (id));
create table motorcycles (type varchar(14) not null, vehicle_id bigint not null, primary key (vehicle_id), foreign key (vehicle_id) references vehicles (id));
create table cars (fuel_type varchar(12) not null, gearbox varchar(15) not null, transmission varchar(12) not null, vehicle_id bigint not null, primary key (vehicle_id), foreign key (vehicle_id) references vehicles (id));
create table photos (id bigint not null auto_increment, vehicle_id bigint not null, url VARCHAR(255), primary key (id), foreign key (vehicle_id) references vehicles(id));
create table reservations (id bigint not null auto_increment, commend varchar(255), datetime_return datetime, datetime_take datetime, is_payed bit not null, bill_id bigint not null unique, status_id bigint not null, user_id bigint not null, vehicle_id bigint not null, version int, primary key (id), foreign key (bill_id) references bills (id), foreign key (status_id) references reservation_statuses (id), foreign key (user_id) references users (id), foreign key (vehicle_id) references vehicles (id));
create table damage_bills (id bigint not null auto_increment, commend varchar(255) not null, cost int not null, reservation_id bigint not null unique, primary key (id), foreign key (reservation_id) references reservations (id));

/* test table*/
INSERT INTO bills (final_cost, pay_datetime) VALUES (100, '2017-04-12 13:00:00');
INSERT INTO bills (final_cost, pay_datetime) VALUES (120, '2018-02-12 13:22:00');

INSERT INTO chats VALUES (1);
INSERT INTO chats VALUES (2);

INSERT INTO cost_strategies (strategy) VALUES ('1-100__3-95__5_90');
INSERT INTO cost_strategies (strategy) VALUES ('1-100__3-97__5_95');
INSERT INTO cost_strategies (strategy) VALUES ('1-100__3-90__5_85');
INSERT INTO cost_strategies (strategy) VALUES ('1-100__3-90__5_85');

INSERT INTO reservation_statuses (status_name) VALUES ('in rent');
INSERT INTO reservation_statuses (status_name) VALUES ('wait for rent');
INSERT INTO reservation_statuses (status_name) VALUES ('returned');

INSERT INTO roles (role_name) VALUES ('admin');
INSERT INTO roles (role_name) VALUES ('user');

INSERT INTO users (login, password) VALUES ('admin','admin');
INSERT INTO users (login, password) VALUES ('alex','1234124');
INSERT INTO users (login, password) VALUES ('max','adr3232');
INSERT INTO users (login, password) VALUES ('crip','12ada');
INSERT INTO users (login, password) VALUES ('lex','asdasf');
INSERT INTO users (login, password) VALUES ('mir','1234asd124');

INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Hi! What about BMW?', '2018-02-13 13:22:00', 1, 2);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Ye, it here', '2018-02-13 13:25:00', 1, 1);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Nice!', '2018-02-13 13:29:00', 1, 2);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Where i can rent car?', '2018-02-18 13:22:00', 2, 3);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Here - link', '2018-02-18 13:28:00', 2, 1);

INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('business', 1);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('luxury', 2);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('budgetary', 3);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('motorcycle', 4);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (6, 2);

INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('asdasdasdasas', '45654646', 2);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('werwer', '6498964', 3);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('sdfsdf', '9871', 4);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('sdf', '6489456321', 6);

INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 12:50:00', 3);
INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 12:40:00', 6);
INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 13:50:00', 4);


INSERT INTO additional_reviews (commend_text, datetime_commend, review_id) VALUES ('Very Nice!', '2018-02-15 12:50:00', 1);
INSERT INTO additional_reviews (commend_text, datetime_commend, review_id) VALUES ('Very Nice!', '2018-02-15 12:00:00', 2);
INSERT INTO additional_reviews (commend_text, datetime_commend, review_id) VALUES ('Very Nice!', '2018-02-15 13:50:00', 3);


INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (1, 'BMW', '645', 120, 2005, 4500, 331, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (2, 'BMW', '645', 60, 2006, 4500, 332, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (3, 'BMW', '645', 70, 2007, 4500, 333, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (4, 'AUDI', 'A4', 120, 2005, 2500, 170, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (5, 'AUDI', 'A5', 110, 2010, 4500, 330, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (6, 'AUDI', 'A6', 120, 2007, 4500, 330, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (7, 'BMW', '740', 100, 2003, 4000, 330, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (8, 'BMW', '320i', 80, 2005, 2000, 330, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (9, 'BMW', '645', 120, 2005, 4500, 330, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (10, 'BMW', '645', 70, 2007, 4500, 334, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (11, 'BMW', '645', 120, 2007, 4500, 335, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (12, 'BMW', '645', 120, 2007, 4500, 336, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (13, 'YAMAHA', 'R1', 50, 2007, 1000, 170, 4);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (14, 'Kawasaki', 'ER-6', 60, 2007, 4500, 336, 4);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (15, 'Minsk', 'R250', 40, 2007, 4500, 336, 4);

INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 1);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 2);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 3);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 4);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 5);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 6);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 7);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 8);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 9);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 10);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 11);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 12);

INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT', 13);
INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT', 14);
INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT', 15);

INSERT INTO photos (vehicle_id, url) VALUES (1, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (4, 'main-https://s.aolcdn.com/commerce/autodata/images/USC70AUC017A021001.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (4, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Audi_A4_2.0_TFSI_quattro.jpg/1200px-Audi_A4_2.0_TFSI_quattro.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (5, 'main-https://s.aolcdn.com/commerce/autodata/images/USC80AUC191A121001.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (5, 'http://img2.autonavigator.ru/pics/030/763/94107_800.jpg?max=1024');
INSERT INTO photos (vehicle_id, url) VALUES (6, 'main-https://s.aolcdn.com/commerce/autodata/images/USC60AUC021B021001.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (6, 'https://www.audi.ru/content/dam/nemo/ru/models/a6/a6/my-2017/1920x1080-gallery/1920x1080_QA6_D_141019_1.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'main-https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAB50BMC271A0101.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/04q1/267350/bmw-645ci-photo-9324-s-original.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://cdn.shopify.com/s/files/1/0848/1940/products/QuickSilver_BM650S_Fit_3_MED_RES_0db83a2c-3344-45f1-8ea6-2849a7c389bf.jpg?v=1490881421');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9i0gI0t6KLqMod7WZg-nBda2Pn0Yqo0gcg9PFZtNmpNy8xY9H');
INSERT INTO photos (vehicle_id, url) VALUES (13, 'main-https://cloud.yamahamotorsports.com/library/img.jpg?id=5a0342352a0ab62a4c816d51&w=840');
INSERT INTO photos (vehicle_id, url) VALUES (14, 'main-http://moto.ironhorse.ru/wp-content/uploads/2011/07/kawasaki-er-6f.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (15, 'main-https://static.baza.farpost.ru/v/1369203294924_bulletin');

INSERT INTO reservations (datetime_return, datetime_take, is_payed, bill_id, status_id, user_id, vehicle_id)
VALUES ('2017-04-12 13:00:00', '2017-04-16 13:00:00', TRUE ,1, 3, 3, 4);
INSERT INTO reservations (datetime_return, datetime_take, is_payed, bill_id, status_id, user_id, vehicle_id)
VALUES ('2017-04-15 13:00:00', '2017-04-19 13:00:00', TRUE ,2, 1, 2, 2);

insert into damage_bills (commend, cost, reservation_id) values ('Damaged door', 50, 1);
