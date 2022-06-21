drop database if exists airfrance_22; 
create database airfrance_22; 
use airfrance_22; 

create table pilote (
	idpilote int(3) not null auto_increment, 
	nom varchar(50) not null, 
	prenom varchar(50) not null,
	adresse varchar(100) ,
	nbheuresvol int(7), 
	bip varchar(20), 
	primary key (idpilote)
); 

create table avion (
	idavion int(3) not null auto_increment, 
	designation varchar(50) not null, 
	constructeur varchar(50) not null,
	nbplaces int(3), 
	primary key (idavion)
); 

create table vol (
	idvol int(3) not null auto_increment, 
	designation varchar(50) not null, 
	datevol date,
	heurevol time, 
	idpilote1 int(3) not null, 
	idpilote2 int(3) not null,
	idavion int(3) not null, 
	primary key (idvol), 
	foreign key(idpilote1) references pilote(idpilote), 
	foreign key(idpilote2) references pilote(idpilote),
	foreign key(idavion) references avion(idavion)
); 

create table user (
	iduser int(3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(50), 
	mdp varchar(255), 
	role enum("admin", "user"),
	primary key(iduser)
);

insert into user values (null, "Tom", "yacine", "a@gmail.com", 
"123", "admin"), 
(null, "Maamar", "Lassana", "b@gmail.com", 
"456", "user");

 























