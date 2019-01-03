drop database aviokompanija;


create database aviokompanija;
use aviokompanija;

-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name) values 
	('admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (username, password, first_name, last_name) values 
	('petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

-- insert authorities
insert into security_authority (name) values ('ROLE_ADMIN'); -- super user
insert into security_authority (name) values ('ROLE_USER'); -- normal user

-- insert mappings between users and authorities
insert into security_user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (user_id, authority_id) values (1, 2); -- admin has ROLE_USER too
insert into security_user_authority (user_id, authority_id) values (2, 2); -- petar has ROLE_USER


insert into tip_karte (naziv) values ('Biznis');
insert into tip_karte (naziv) values ('Ekonomik');

insert into prevoznik (naziv) values ('AirSerbia');
insert into prevoznik (naziv) values ('TurkisAir');
insert into prevoznik (naziv) values ('USEAir');

insert into karta (ime , prezime , broj_sedista , tip_karte_id) values ('Djordje' , 'Mladenovic' , 'B21' , 1);
insert into karta (ime , prezime , broj_sedista , tip_karte_id) values ('Goran' , 'Savovic' , 'E21' , 2);
insert into karta (ime , prezime , broj_sedista , tip_karte_id) values ('Vlada' , 'Cvija' , 'B21' , 1); 
insert into karta (ime , prezime , broj_sedista , tip_karte_id) values ('Milo' , 'Milos' , 'E34' , 2);

insert into avion (broj_leta , vreme_leta , karta_id , prevoznik_id) values (23 , '19:00' , 1 , 2 );
insert into avion (broj_leta , vreme_leta , karta_id , prevoznik_id) values (2 , '08:00' , 2 , 3 );
insert into avion (broj_leta , vreme_leta , karta_id , prevoznik_id) values (54 , '10:00' , 3 , 1 );