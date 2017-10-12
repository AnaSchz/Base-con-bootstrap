create database Usuario;
use Usuario;
create table users(id int not null auto_increment primary key, nombre varchar(20), pass varchar(20));

insert into users(nombre, pass) values('Ana', 'anasana');

select * from users;

Select * from users where nombre = 'Ana' && pass= 'anasana';