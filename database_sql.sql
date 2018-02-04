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
create table reservations (id bigint not null auto_increment, commend varchar(255), datetime_return datetime, datetime_take datetime, is_payed bit not null, bill_id bigint not null unique, status_id bigint not null, user_id bigint not null, vehicle_id bigint not null, primary key (id), foreign key (bill_id) references bills (id), foreign key (status_id) references reservation_statuses (id), foreign key (user_id) references users (id), foreign key (vehicle_id) references vehicles (id));
create table damage_bills (id bigint not null auto_increment, commend varchar(255) not null, cost int not null, reservation_id bigint not null unique, primary key (id), foreign key (reservation_id) references reservations (id));


