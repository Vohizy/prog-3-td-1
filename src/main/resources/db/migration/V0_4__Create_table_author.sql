create table author
(
    id     serial,
    particularity varchar,
    name  varchar,
    birth_date DATE,
    primary key (id)
);
alter sequence author_id_seq restart WITH 10;