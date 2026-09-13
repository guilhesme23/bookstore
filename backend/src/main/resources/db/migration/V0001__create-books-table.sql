create table books(
    id serial primary key,
    title varchar(2048) not null,
    description text not null,
    author varchar(120),
    rating numeric(3,2) default 5.0,
    num_ratings integer default 0,
    total_sum_ratings integer default 0,
    genres jsonb default '[]'::jsonb,
    isbn varchar(13) unique,
    publisher varchar(255),
    language varchar(100),
    translation boolean default false,
    original_language varchar(100)
);