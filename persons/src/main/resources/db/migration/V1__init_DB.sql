create table hibernate_sequences
(
    sequence_name varchar(255) not null,
    next_val      int8,
    primary key (sequence_name)
);

insert into hibernate_sequences(sequence_name, next_val)
values ('default', 0);

create table person
(
    id         int8 not null,
    email      varchar(255),
    name       varchar(255),
    patronymic varchar(255),
    surname    varchar(255),
    telephone  int4 not null,
    primary key (id)
)