create table bills (id bigint not null auto_increment, final_cost int not null, pay_datetime datetime, primary key (id));
create table chats (id bigint not null auto_increment, primary key (id));
create table cost_strategies (id bigint not null auto_increment, strategy varchar(80) not null, primary key (id));
create table reservation_statuses (id bigint not null auto_increment, status_name varchar(30) not null unique, primary key (id));
create table roles (id bigint not null auto_increment, role_name varchar(30) not null unique, primary key (id));
create table users (id bigint not null auto_increment, login varchar(40) not null unique, password varchar(60) not null, primary key (id));
create table chat_lines (id bigint not null auto_increment, line_text varchar(255), date_time datetime, chat_id bigint not null, user_id bigint not null, primary key (id), foreign key (chat_id) references chats (id), foreign key (user_id) references users (id));
create table vehicle_categories (id bigint not null auto_increment, category_name varchar(30) not null unique, category_cost_strategy_id bigint not null unique, primary key (id), foreign key (category_cost_strategy_id) references cost_strategies (id));
create table users_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id), foreign key (role_id) references roles (id), foreign key (user_id) references users (id));
create table additional_users_info (id bigint not null auto_increment, driving_licence_info varchar(255) not null unique, passport_info varchar(255) not null unique, user_id bigint not null unique, primary key (id), foreign key (user_id) references users (id));
create table reviews (id bigint not null auto_increment, commend_text varchar(255) not null, datetime_commend datetime, user_id bigint not null, primary key (id), foreign key (user_id) references users (id));
create table vehicles (id bigint not null auto_increment, cubic_capacity int not null, manufacture varchar(30) not null, model varchar(30) not null, power_ int not null, stanadart_price int not null, year int not null, category_id bigint not null, primary key (id), foreign key (category_id) references vehicle_categories (id));
create table motorcycles (type varchar(14) not null, vehicle_id bigint not null, primary key (vehicle_id), foreign key (vehicle_id) references vehicles (id));
create table cars (fuel_type varchar(12) not null, gearbox varchar(15) not null, transmission varchar(12) not null, vehicle_id bigint not null, primary key (vehicle_id), foreign key (vehicle_id) references vehicles (id));
create table photos (id bigint not null auto_increment, vehicle_id bigint not null, url VARCHAR(255), primary key (id), foreign key (vehicle_id) references vehicles(id));
create table reservations (id bigint not null auto_increment, commend varchar(255), datereturn date, datetake date, is_payed bit not null, bill_id bigint not null unique, status_id bigint not null, user_id bigint not null, vehicle_id bigint not null, version int, primary key (id), foreign key (bill_id) references bills (id), foreign key (status_id) references reservation_statuses (id), foreign key (user_id) references users (id), foreign key (vehicle_id) references vehicles (id));
create table damage_bills (id bigint not null auto_increment, commend varchar(255) not null, cost int not null, reservation_id bigint not null unique, primary key (id), foreign key (reservation_id) references reservations (id));

/* test table*/
INSERT INTO bills (final_cost, pay_datetime) VALUES (100, '2017-04-12 13:00:00');
INSERT INTO bills (final_cost, pay_datetime) VALUES (120, '2018-02-12 13:22:00');

INSERT INTO chats VALUES (1);
INSERT INTO chats VALUES (2);

INSERT INTO cost_strategies (strategy) VALUES ('1-2=100_3-4=95_5-10=90');
INSERT INTO cost_strategies (strategy) VALUES ('1-3=100_4-7=93_7-15=85');
INSERT INTO cost_strategies (strategy) VALUES ('1-8=100_9-15=95_15-30=90');
INSERT INTO cost_strategies (strategy) VALUES ('1-5=100_6-9=95_10-20=90');

INSERT INTO reservation_statuses (status_name) VALUES ('order created');
INSERT INTO reservation_statuses (status_name) VALUES ('in rent');
INSERT INTO reservation_statuses (status_name) VALUES ('wait for rent');
INSERT INTO reservation_statuses (status_name) VALUES ('returned');

INSERT INTO roles (role_name) VALUES ('admin');
INSERT INTO roles (role_name) VALUES ('user');

INSERT INTO users (login, password) VALUES ('admin','$2a$12$M.xkFNAbfWAc7xXb.vM9UuMvBsugvOsYUiLQe.MUweR02ziiXE3c2');
INSERT INTO users (login, password) VALUES ('admin1','$2a$12$KBOvrSVOZ7E5sOz8LbihkuuHRAmUejiJBQzMtIu303vXo8qplpLQq');
INSERT INTO users (login, password) VALUES ('alex','$2a$12$wyAFxWgf742inOZbnEsvAuYakUXcXXhTmpL4kH1VWxuIKD9M2CI4e');
INSERT INTO users (login, password) VALUES ('max','$2a$12$yjhgvTZkOhTl3rT1T22qeetqHGmF4eUMXg0YAxrQPuB0ibtl4VSgi');
INSERT INTO users (login, password) VALUES ('crip','$2a$12$USOkhqy2YOh0bIqojUErq.l9KqoZ5FpSkqdUdx4pRFxj2ERvxvDCu');
INSERT INTO users (login, password) VALUES ('lex','$2a$12$7wpfQnmSJyL7i0bjm1yTuOpjIJ5puctnGJsV61SMD4bZwYT4n0SBe');
INSERT INTO users (login, password) VALUES ('mir','$2a$12$InqwvcCRZTPcZ15tg4yeQObVZa.BDG5W/pGqhqTkDRdVR0od/Wk2a');

INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Привет, БМВ в наличии?', '2018-02-13 13:22:00', 1, 2);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Да', '2018-02-13 13:25:00', 1, 1);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Отлично!', '2018-02-13 13:29:00', 1, 2);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('Как арендовать авто', '2018-02-18 13:22:00', 2, 3);
INSERT INTO chat_lines (line_text, date_time, chat_id, user_id) VALUES ('ссылка тут', '2018-02-18 13:28:00', 2, 1);

INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('business', 1);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('luxury', 2);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('budgetary', 3);
INSERT INTO vehicle_categories (category_name, category_cost_strategy_id) VALUES ('motorcycle', 4);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (6, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (7, 2);

INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('licence_alex', 'passport_alex', 3);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('licence_max', 'passport_max', 4);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('licence_crip', 'passport_crip', 5);
INSERT INTO additional_users_info (driving_licence_info, passport_info, user_id) VALUES ('licence_mir', 'passport_mir', 7);

INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 12:50:00', 3);
INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 12:40:00', 6);
INSERT INTO reviews (commend_text, datetime_commend, user_id) VALUES ('Nice!', '2018-02-15 13:50:00', 4);


INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (1, 'BMW', '535i', 120, 2010, 3500, 306, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (2, 'YAMAHA', 'R1', 50, 2005, 1000, 172, 4);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (3, 'Volkswagen', 'Polo', 60, 2015, 1600, 105, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (4, 'Opel', 'Insignia', 100, 2010, 2000, 220, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (5, 'BMW', '325i', 90, 2005, 2500, 218, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (6, 'BMW', '520i', 130, 2016, 2000, 184, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (7, 'BMW', '750i ', 130, 2013, 4400, 450, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (8, 'BMW', 'X5', 100, 2011, 3000, 306, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (9, 'Kia', 'Rio', 70, 2017, 1600, 123, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (10, 'Kia', 'Cee''d', 70, 2015, 1600, 130, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (11, 'Opel', 'Astra OPC', 110, 2013, 2000, 280, 2);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (12, 'Ford', 'Mondeo', 80, 2012, 2000, 145, 1);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (13, 'Ford', 'Focus', 70, 2013, 2000, 150, 3);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (14, 'Kawasaki', 'Z 1000', 70, 2011, 1000, 138, 4);
INSERT INTO vehicles (id, manufacture, model, stanadart_price, year, cubic_capacity, power_, category_id) VALUES (15, 'Ducati', 'Streetfighter', 70, 2013, 848, 134, 4);

INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 1);

INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT', 2);

INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'MANUAL', 'FRONT_WHEEL', 3);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'AUTOMATIC', 'FRONT_WHEEL', 4);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 5);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'REAR_WHEEL', 6);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'FOUR_WHEEL', 7);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'FOUR_WHEEL', 8);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'AUTOMATIC', 'FRONT_WHEEL', 9);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'AUTOMATIC', 'FRONT_WHEEL', 10);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'MANUAL', 'FRONT_WHEEL', 11);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'MANUAL', 'FRONT_WHEEL', 12);
INSERT INTO cars (fuel_type, gearbox, transmission, vehicle_id) VALUES ('PETROL', 'SEMI_AUTOMATIC', 'FRONT_WHEEL', 13);


INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT_TOURING', 14);
INSERT INTO motorcycles (type, vehicle_id) VALUES ('SPORT', 15);

INSERT INTO photos (vehicle_id, url) VALUES (1, 'main-https://pp.userapi.com/c846323/v846323990/453b/hSGFd77ApJQ.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://pp.userapi.com/c846323/v846323990/4544/KSck6JsKO1A.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://pp.userapi.com/c846323/v846323990/454d/sT-61th0enI.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (1, 'https://pp.userapi.com/c846323/v846323990/4556/da4z9djpw94.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (2, 'main-https://pp.userapi.com/c846323/v846323990/4572/R6IiMcGGMs8.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://pp.userapi.com/c846323/v846323990/457b/mzILwuMK46M.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://pp.userapi.com/c846323/v846323990/4584/SWLPPkD8pqw.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (2, 'https://pp.userapi.com/c846323/v846323990/458d/yTw5PcWJ2VI.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (3, 'main-https://pp.userapi.com/c846323/v846323990/4596/LNtll-fNVao.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://pp.userapi.com/c846323/v846323990/459f/DoxnA_oWoNg.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://pp.userapi.com/c846323/v846323990/45a8/yyEQiup2FSs.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (3, 'https://pp.userapi.com/c846323/v846323990/45b1/FveWG9136Ws.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (4, 'main-https://pp.userapi.com/c846323/v846323990/45ba/sQaRu3zDOeI.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (4, 'https://pp.userapi.com/c846323/v846323990/45c3/3qRQGaionPM.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (4, 'https://pp.userapi.com/c846323/v846323990/45cc/arpgz4v4JVA.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (4, 'https://pp.userapi.com/c846323/v846323990/45d5/jIKA6zHzz3k.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (5, 'main-https://pp.userapi.com/c846323/v846323990/45de/6adQAJ92S7Y.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (5, 'https://pp.userapi.com/c846323/v846323990/45e7/wS-mAElG4oo.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (5, 'https://pp.userapi.com/c846323/v846323990/45f0/W9nDpb9xZrc.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (5, 'https://pp.userapi.com/c846323/v846323990/45de/6adQAJ92S7Y.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (6, 'main-https://pp.userapi.com/c846323/v846323990/4602/Z9U38Va-_J4.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (6, 'https://pp.userapi.com/c846323/v846323990/460b/B4svmbBKzSs.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (6, 'https://pp.userapi.com/c846323/v846323990/4618/YvgakcFdjHI.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (6, 'https://pp.userapi.com/c846323/v846323990/4621/hVLP4tnqXBs.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (7, 'main-https://pp.userapi.com/c846323/v846323990/462a/gU113HQkKAk.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://pp.userapi.com/c846323/v846323990/4633/CfnMhAGIdvM.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://pp.userapi.com/c846323/v846323990/463c/SEB0iB8ruV8.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (7, 'https://pp.userapi.com/c846323/v846323990/4645/IwPHKK186j4.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (8, 'main-https://pp.userapi.com/c846323/v846323990/4656/J_Uid26lurc.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://pp.userapi.com/c846323/v846323990/465f/kR1Al-kfAZs.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://pp.userapi.com/c846323/v846323990/4668/R3aCJQt-v2s.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (8, 'https://pp.userapi.com/c846323/v846323990/4671/M2SAUAlPBcM.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (9, 'main-https://pp.userapi.com/c846323/v846323990/4683/pjv68z12ghY.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://pp.userapi.com/c846323/v846323990/468c/R-fWt717olk.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://pp.userapi.com/c846323/v846323990/4695/Ns4_R4SFYP8.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (9, 'https://pp.userapi.com/c846323/v846323990/469e/3l0UKhcH8go.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (10, 'main-https://pp.userapi.com/c846323/v846323990/46a7/IHW8y-q4Q04.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://pp.userapi.com/c846323/v846323990/46b0/aCF2BAU3nrs.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://pp.userapi.com/c846323/v846323990/46b9/gA0p7c5dAZo.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (10, 'https://pp.userapi.com/c846323/v846323990/46c2/R4xC0x2aLjU.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (11, 'main-https://pp.userapi.com/c846323/v846323990/46cb/3EX4bAGhstI.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://pp.userapi.com/c846323/v846323990/46d4/CROi22ticiM.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://pp.userapi.com/c846323/v846323990/46dd/kB1_ZrzvlLI.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (11, 'https://pp.userapi.com/c846323/v846323990/46e6/RrdbC5F7-yw.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (12, 'main-https://pp.userapi.com/c846323/v846323990/46f8/98wjmKHwr-E.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://pp.userapi.com/c846323/v846323990/4701/JvJu663090o.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://pp.userapi.com/c846323/v846323990/470a/V4eW-TmWLcw.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (12, 'https://pp.userapi.com/c846323/v846323990/4713/AQuhtWA2Dw4.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (13, 'main-https://pp.userapi.com/c846323/v846323990/4725/8v65dPp5khA.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (13, 'https://pp.userapi.com/c846323/v846323990/472e/v3rbKQXo55g.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (13, 'https://pp.userapi.com/c846323/v846323990/4737/ze4PWUXdIl4.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (13, 'https://pp.userapi.com/c846323/v846323990/4740/_AlkHyzfd0Y.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (14, 'main-https://pp.userapi.com/c846323/v846323990/4752/tpwLAqG8IPE.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (14, 'https://pp.userapi.com/c846323/v846323990/475b/Lu2YBnpnpe4.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (14, 'https://pp.userapi.com/c846323/v846323990/4764/GdWG7VKrYJs.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (14, 'https://pp.userapi.com/c846323/v846323990/476d/kRjqTrDWCxA.jpg');

INSERT INTO photos (vehicle_id, url) VALUES (15, 'main-https://pp.userapi.com/c846323/v846323990/477f/mIa6kmxuKpY.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (15, 'https://pp.userapi.com/c846323/v846323990/4788/c0tOLf1g9qk.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (15, 'https://pp.userapi.com/c846323/v846323990/4791/Ive2geEnEm8.jpg');
INSERT INTO photos (vehicle_id, url) VALUES (15, 'https://pp.userapi.com/c846323/v846323990/479a/V5iLpvh_4eA.jpg');

INSERT INTO reservations (datereturn, datetake, is_payed, bill_id, status_id, user_id, vehicle_id, version)
VALUES ('2017-04-16', '2017-04-12', TRUE ,1, 3, 3, 4, 0);
INSERT INTO reservations (datereturn, datetake, is_payed, bill_id, status_id, user_id, vehicle_id, version)
VALUES ('2017-04-19', '2017-04-15', TRUE ,2, 1, 2, 2, 0);

insert into damage_bills (commend, cost, reservation_id) values ('Поврежденная дверь', 50, 1);
