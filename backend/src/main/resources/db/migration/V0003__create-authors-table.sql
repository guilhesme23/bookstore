create table authors(
    id serial primary key,
    name varchar(255) not null,
    birthplace varchar(255),
    dob date,
    bio text,
    active boolean not null default true
);