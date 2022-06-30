# -----------------------------
# localitées
#------------------------------
INSERT INTO locality
(label, postal_code)
values('chatelet', 6200);

INSERT INTO locality
(label, postal_code)
values('namur', 5000);

INSERT INTO locality
(label, postal_code)
values('mons', 7000);

INSERT INTO locality
(label, postal_code)
values('Wavre', 1300);

INSERT INTO locality
(label, postal_code)
values('bruxelles', 1000);

# -----------------------------
# stations
#------------------------------

INSERT INTO station
(label,phone_number,locality)
values('chatelet est',"0416/820583",1);

INSERT INTO station
(label,phone_number,locality)
values('chatelet ouest',"0418/295727",1);

INSERT INTO station
(label,phone_number,locality)
values('namur nord',"0418/502957",2);

INSERT INTO station
(label,phone_number,locality)
values('namur sud',"0418/57185",2);

INSERT INTO station
(label,phone_number,locality)
values('mons ouest',"0419/681985",3);

INSERT INTO station
(label,phone_number,locality)
values('mons nord',"0429/682850",3);

INSERT INTO station
(label,phone_number,locality)
values('wavre sud',"0486/827582",4);

INSERT INTO station
(label,phone_number,locality)
values('wavre est',"0419/582759",4);

INSERT INTO station
(label,phone_number,locality)
values('bruxelles nord',"0405/828502",5);

INSERT INTO station
(label,phone_number,locality)
values('bruxelles nord',"0402/948294",5);

# -----------------------------
# users
#------------------------------
INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Fontaine', 'Jean-Francois', CONVERT('2000-05-06', date), "jean.francois.f@gmail.com", 111436, "0495/135060", true, null, 1);

INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Legrand', 'Martin ', CONVERT('1994-09-03', date), "martin.l@gmail.com", 111436, "0495/183257", false, null, 2);

INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Lepetit', 'Bernard', CONVERT('2002-10-01', date), "beber@simens.be", 111436, null, false, "jean.francois.f@gmail.com", 3);

INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Domi', 'test', CONVERT('1999-10-01', date), "domi@test.ex", 111436, null, false, null, 3);

INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Domi', 'test', CONVERT('1999-10-01', date), "domi2@test.ex", 111436, null, false, null, 3);

INSERT INTO user
(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)
values('Domi', 'test', CONVERT('1999-10-01', date), "domi3@test.ex", 111436, null, false, "domi@test.ex", 3);

# -----------------------------
# types d'abonnement
#------------------------------

INSERT INTO type_of_subscription
(name,price_per_month)
values('none', 0);

INSERT INTO type_of_subscription
(name,price_per_month)
values('abonnement vtt',7.99);

INSERT INTO type_of_subscription
(name,price_per_month)
values('abonnement ville',8.99);

INSERT INTO type_of_subscription
(name,price_per_month)
values('abonnement électrique',10.99);

# -----------------------------
# abonnements
#------------------------------

INSERT INTO subscription
(user,sub_id)
values('jean.francois.f@gmail.com',4);

INSERT INTO subscription
(user,sub_id)
values('beber@simens.be',2);

INSERT INTO subscription
(user,sub_id)
values('martin.l@gmail.com',3);

INSERT INTO subscription
(user,sub_id)
values('domi@test.ex',1);

INSERT INTO subscription
(user,sub_id)
values('domi2@test.ex',2);

INSERT INTO subscription
(user,sub_id)
values('domi3@test.ex',3);

# -----------------------------
# types de vélo
#------------------------------

INSERT INTO bike_type
(label, type_subscription)
values('vtt', 2);

INSERT INTO bike_type
(label, type_subscription)
values('ville', 3);

INSERT INTO bike_type
(label, type_subscription)
values('électrique', 4);

# -----------------------------
# admins
#------------------------------

INSERT INTO admin
(name,password)
values('admin1',-779514013);

INSERT INTO admin
(name,password) 
values('admin2',-779514013);

INSERT INTO admin
(name,password)
values('admin3',-779514013);

# -----------------------------
# vélos
#------------------------------
INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-10-08', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-04-06', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-03-16', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2019-10-24', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-08-18', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-12-08', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-09-21', date), 1);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-06-25', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-07-24', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-02-01', date), 2);
INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-05-15', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-12-10', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-01-13', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-11-20', date), 2);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-07-15', date), 3);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2022-02-04', date), 3);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-01-03', date), 3);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-04-28', date), 3);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2020-11-14', date), 3);

INSERT INTO bike
(last_revision_date, type)
values(CONVERT('2021-10-10', date), 3);

# -----------------------------
# modifications
#------------------------------

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2022-03-20', date), 1,3, 'rendre indisponible');

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2020-10-16', date), 2,11, 'rendre disponible');

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2016-10-16', date), 3,14, 'rendre disponible');

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2019-10-16', date), 2,7, 'rendre indisponible');

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2016-10-16', date), 3,16, 'rendre disponible');

INSERT INTO modification
(date,admin,bike,type_of_change)
values(CONVERT('2015-10-16', date), 1,2, 'rendre indisponible');

# -----------------------------
# locations
#------------------------------

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-16', date),CONVERT('2018-02-16', date),"jean.francois.f@gmail.com",15,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-16', date),CONVERT('2018-02-16', date),"jean.francois.f@gmail.com",15, 2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"jean.francois.f@gmail.com",16,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"jean.francois.f@gmail.com",16,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"jean.francois.f@gmail.com",17,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",18,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",18,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"jean.francois.f@gmail.com",19,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"jean.francois.f@gmail.com",19,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",20,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",20,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",15,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",16,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"jean.francois.f@gmail.com",20,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com",20,3,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"jean.francois.f@gmail.com", 17,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"jean.francois.f@gmail.com",16,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"jean.francois.f@gmail.com",19,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-02-16', date),CONVERT('2020-02-16', date),"jean.francois.f@gmail.com",20,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-02-14', date),CONVERT('2020-02-14', date),"jean.francois.f@gmail.com",19,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-03-14', date),CONVERT('2020-03-14', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-03-14', date),CONVERT('2020-03-14', date),"jean.francois.f@gmail.com",17,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"jean.francois.f@gmail.com",15,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"jean.francois.f@gmail.com",16,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",15,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",18,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"jean.francois.f@gmail.com",17,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",17,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",20,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",15,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"jean.francois.f@gmail.com",17,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"jean.francois.f@gmail.com",18,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",19,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"jean.francois.f@gmail.com",20,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"jean.francois.f@gmail.com",17,3,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"jean.francois.f@gmail.com",18,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-02-16', date),CONVERT('2019-02-16', date),"martin.l@gmail.com",9,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-02-16', date),CONVERT('2019-02-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-03-16', date),CONVERT('2019-03-16', date),"martin.l@gmail.com",11,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"martin.l@gmail.com",12,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",14,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",12,3,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",11,3,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",9,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",13,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-08-16', date),CONVERT('2019-08-16', date),"martin.l@gmail.com",12,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-04-16', date),CONVERT('2019-04-16', date),"martin.l@gmail.com",9,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-04-16', date),CONVERT('2019-04-16', date),"martin.l@gmail.com",14,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",12,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",10,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",13,2,1);


INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-02-16', date),CONVERT('2019-02-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-02-16', date),CONVERT('2019-02-16', date),"martin.l@gmail.com",9,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-03-16', date),CONVERT('2019-03-16', date),"martin.l@gmail.com",9,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-03-16', date),CONVERT('2019-03-16', date),"martin.l@gmail.com",12,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-04-16', date),CONVERT('2019-04-16', date),"martin.l@gmail.com",11,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-04-16', date),CONVERT('2019-04-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",12,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",11,3,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",12,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-06-16', date),CONVERT('2019-06-16', date),"martin.l@gmail.com",11,5,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",9,4,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2019-05-16', date),"martin.l@gmail.com",10,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2019-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",11,4,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-30', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",9,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",11,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",14,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"martin.l@gmail.com",14,2,1);


INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-16', date),CONVERT('2018-02-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-01', date),CONVERT('2018-02-16', date),"martin.l@gmail.com",12,2,5);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"martin.l@gmail.com",12,1,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",11,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",13,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"martin.l@gmail.com",12,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"martin.l@gmail.com",9,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",10,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-01-16', date),CONVERT('2018-01-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-05-16', date),CONVERT('2018-05-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"martin.l@gmail.com",12,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-04-16', date),CONVERT('2017-04-16', date),"martin.l@gmail.com",13,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-06-16', date),CONVERT('2017-06-16', date),"martin.l@gmail.com",11,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-06-16', date),CONVERT('2017-06-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-02-16', date),CONVERT('2017-02-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-02-16', date),CONVERT('2017-02-16', date),"martin.l@gmail.com",10,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-03-16', date),CONVERT('2017-03-16', date),"martin.l@gmail.com",9,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-03-16', date),CONVERT('2017-03-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-04-16', date),CONVERT('2017-04-16', date),"martin.l@gmail.com",13,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-04-16', date),CONVERT('2017-04-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-05-16', date),CONVERT('2017-05-16', date),"martin.l@gmail.com",10,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-05-16', date),CONVERT('2017-05-16', date),"martin.l@gmail.com",13,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-06-16', date),CONVERT('2017-06-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-08-16', date),CONVERT('2017-08-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-05-16', date),CONVERT('2017-05-16', date),"martin.l@gmail.com",12,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-05-16', date),CONVERT('2017-05-16', date),"martin.l@gmail.com",12,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-05-16', date),CONVERT('2017-05-16', date),"martin.l@gmail.com",9,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-04-16', date),CONVERT('2017-04-16', date),"martin.l@gmail.com",14,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-12-16', date),CONVERT('2017-12-16', date),"martin.l@gmail.com",11,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-12-16', date),CONVERT('2017-12-16', date),"martin.l@gmail.com",14,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2017-06-16', date),CONVERT('2017-06-16', date),"martin.l@gmail.com",16,2,1);


INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-16', date),CONVERT('2018-02-16', date),"beber@simens.be",1,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-02-16', date),CONVERT('2018-02-16', date),"beber@simens.be",2,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"beber@simens.be",3,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-03-16', date),CONVERT('2018-03-16', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"beber@simens.be",5,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-04-16', date),CONVERT('2018-04-16', date),"beber@simens.be",6,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-09-16', date),CONVERT('2018-09-16', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"beber@simens.be",4,5,4);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2018-06-16', date),CONVERT('2018-06-16', date),"beber@simens.be",4,3,3);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-05-16', date),CONVERT('2022-05-16', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-05-16', date),CONVERT('2022-05-16', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-05-16', date),CONVERT('2022-05-16', date),"beber@simens.be",4,5,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-05-16', date),CONVERT('2022-05-16', date),"beber@simens.be",4,3,5);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-04-16', date),CONVERT('2022-04-16', date),"beber@simens.be",4,3,3);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-04-16', date),CONVERT('2022-04-16', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-06-16', date),CONVERT('2022-06-16', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2022-06-16', date),CONVERT('2022-06-16', date),"beber@simens.be",4,5,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-02-16', date),CONVERT('2020-02-16', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-02-14', date),CONVERT('2020-02-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-03-14', date),CONVERT('2020-03-14', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-03-14', date),CONVERT('2020-03-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-04-14', date),CONVERT('2020-04-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-06-14', date),CONVERT('2020-06-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"beber@simens.be",4,4,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-07-14', date),CONVERT('2020-07-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-05-14', date),CONVERT('2020-05-14', date),"beber@simens.be",4,5,5);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2020-08-14', date),CONVERT('2020-08-14', date),"beber@simens.be",4,2,1);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2021-05-14', date),CONVERT('2020-05-14', date),"beber@simens.be",4,3,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2021-05-14', date),CONVERT('2021-05-14', date),"beber@simens.be",7,3,3);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2021-06-14', date),CONVERT('2021-06-14', date),"beber@simens.be",4,1,2);

INSERT INTO hiring
(start_date,end_date,user,bike,start_station,end_station)
values(CONVERT('2021-06-14', date),CONVERT('2021-06-14', date),"beber@simens.be",4,2,1);