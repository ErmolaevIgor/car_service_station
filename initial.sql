create table customer_statuses
(
    id bigserial not null
        constraint customer_statuses_pk
            primary key,
    name varchar not null
);

create table genders
(
    id bigserial not null
        constraint genders_pk
            primary key,
    name varchar
);

create table customers
(
    id bigserial not null
        constraint customers_pk
            primary key,
    first_name varchar,
    last_name varchar,
    email varchar,
    phone varchar,
    gender_id bigint
        constraint customers_genders_id_fk
            references genders,
    status_id bigint
        constraint customers_customer_statuses_id_fk
            references customer_statuses
);

create table customer_cars
(
    id bigserial not null
        constraint customer_cars_pkey
            primary key,
    vin_number varchar not null,
    registration_number varchar not null,
    brand varchar not null,
    model varchar not null,
    engine_modification varchar,
    year_of_issue varchar,
    mileage varchar
);

create unique index customer_cars_vin_number_uindex
    on customer_cars (vin_number);

create unique index customer_cars_registration_number_uindex
    on customer_cars (registration_number);

create table users
(
    id bigserial
        constraint users_pk
            primary key,
    email varchar,
    password varchar
);

INSERT INTO customer_statuses (id, name) VALUES (1, 'new');
INSERT INTO customer_statuses (id, name) VALUES (2, 'potential client');
INSERT INTO customer_statuses (id, name) VALUES (3, 'customer');
INSERT INTO customer_statuses (id, name) VALUES (4, 'refusal');

INSERT INTO genders (id, name) VALUES (1, 'male');
INSERT INTO genders (id, name) VALUES (2, 'female');
INSERT INTO genders (id, name) VALUES (3, 'unknown');

INSERT INTO customer_cars (vin_number, registration_number, brand, model, engine_modification, year_of_issue, mileage) VALUES ('12345678912345678', '123456789', 'Audi', 'A4', 'X20XEV', '2005', '125687');

INSERT INTO customers (first_name, last_name, email, phone, status_id, gender_id) VALUES ('Ivan', 'Petrov', 'i.petrov@example.com', '+7 (904) 519-4277', 1, 1);

INSERT INTO users (email, password) VALUES ('admin', '{noop}admin');