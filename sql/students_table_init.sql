create schema if not exists edu_schema;

create table if not exists edu_schema.students
(
    id        bigserial
    constraint students_pk
    primary key,
    firstname varchar,
    lastname  varchar
);