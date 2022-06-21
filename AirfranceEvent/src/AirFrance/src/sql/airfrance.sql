	Drop database if exists airfrance_22;
Create database if not exists airfrance_22;
Use airfrance_22;

Drop table if exists pilote;
Create table if not exists pilote (
	idpilote int(3) not null auto_increment,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	adresse varchar(255),
	nbheuresvol int(7),
	bip varchar(20),
	primary key (idpilote)
) ENGINE=InnoDB, CHARSET=utf8;

Drop table if exists avion;
Create table if not exists avion (
	idavion int(3) not null auto_increment,
	designation varchar(50) not null,
	constructeur varchar(50) not null,
	nbplaces int(3),
	primary key (idavion)
) ENGINE=InnoDB, CHARSET=utf8;

Drop table if exists vol;
Create table if not exists vol (
	idvol int(3) not null auto_increment,
	designation varchar(50) not null,
	datevol date,
	heurevol time,
	idpilote1 int(3) not null,
	idpilote2 int(3) not null,
	idavion int(3) not null,
	primary key (idvol),
	foreign key (idpilote1) references pilote (idpilote)
	on update cascade
	on delete cascade,
	foreign key (idpilote2) references pilote (idpilote)
	on update cascade
	on delete cascade,
	foreign key (idavion) references avion (idavion)
	on update cascade
	on delete cascade
) ENGINE=InnoDB, CHARSET=utf8;

Create or replace view pav as (
	select p.nom, p.prenom, a.designation as avion, v.designation as vol, v.datevol, v.heurevol
	from pilote p, avion a, vol v
	where p.idpilote = v.idpilote1
	and a.idavion = v.idvol
);

create table userPPE(
iduser int(3) not null auto_increment,
nom varchar(50),
prenom varchar(50),
email varchar(50),
mdp varchar(255),
role enum("admin","user"),
primary key(iduser)
);
insert into user values (null, "Tom", "yacinne", "a@gmail.com", "123", "admin"),
	(null, "Mammar", "Lassana", "b@gmail.com", "456", "user");

