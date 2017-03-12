drop table if exists city;

create table city (id int primary key auto_increment, name varchar(30), state varchar(30), country varchar(30));

insert into city (name, state, country) values ('San Francisco', 'CA', 'US');
insert into city (name, state, country) values ('Dublin', 'DC', 'IE');
insert into city (name, state, country) values ('Beijing', 'HB', 'CN');
