CREATE TABLE locality(
    id int AUTO_INCREMENT primary key,
    label varchar(50) not null,
    postal_code numeric(4) not null
);

CREATE TABLE user (
    email_address varchar(50) primary key, 
                            check (email_address LIKE '%@%.%'),
    last_name varchar(50) not null,
    first_name varchar(50) not null,
    birthday date not null,
    password int not null,
    tel_number varchar(11),
		check (tel_number LIKE '04__/%'),
    agree_receive_pub bit not null,
    sponsor varchar(50),
        foreign key (sponsor) references user(email_address),
    residence int not null,
        foreign key (residence) references locality(ID)
);

CREATE TABLE station(
    id int AUTO_INCREMENT primary key,
    label varchar(50) not null,
    phone_number varchar(11) not null,
        check(phone_number LIKE'04__/%'),
    locality int not null,
        foreign key (locality) references locality(id)
);

CREATE TABLE type_of_subscription(
    id int AUTO_INCREMENT primary key,
    name varchar(50) not null,
    price_per_month numeric(4,2) not null
);

CREATE TABLE subscription(
    user varchar(50) not null,
        foreign key (user) references user(email_address),
     sub_id int DEFAULT 1,
        foreign key (sub_id) references type_of_subscription(id)
);

CREATE TABLE bike_type(
    id int AUTO_INCREMENT  primary key,
    label varchar(50) not null unique,
    type_subscription int,
		constraint foreign key (type_subscription) references type_of_subscription(id)
);


CREATE TABLE bike(
    id int AUTO_INCREMENT primary key,
    last_revision_date date not null,
    type int not null,
		constraint foreign key(type) references bike_type(id)
);

CREATE TABLE admin(
    id int AUTO_INCREMENT primary key,
    name varchar(50) not null,
    password int not null
);

CREATE TABLE modification(
    date date not null,
    admin int not null,
        foreign key (admin) references admin(id),
    bike int not null,
        foreign key (bike) references bike(id),
    type_of_change varchar(50) not null,
    primary key (date,admin,bike)
);

CREATE TABLE hiring(
    start_date date not null,
    end_date date,
    user varchar(50) not null,
        foreign key (user) references user(email_address),
    bike int not null,
        foreign key (bike) references bike(id),
    start_station int not null,
        foreign key (start_station) references station(id),
    end_station int,
        foreign key (end_station) references station(id),
	primary key (start_date, start_station,user,bike)
);