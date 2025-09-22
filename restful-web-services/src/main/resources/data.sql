insert into user_details(id, name, birth_date)
values(10001, 'Kaan', CURRENT_DATE());

insert into user_details(id, name, birth_date)
values(10002, 'Ahmet', CURRENT_DATE());

insert into user_details(id, name, birth_date)
values(10003, 'Mehmet', CURRENT_DATE());


insert into post(id, description, user_id)
values(20001, 'I want to learn Spring Boot', 10001);

insert into post(id, description, user_id)
values(20002, 'I want to learn DevOps', 10001);

insert into post(id, description, user_id)
values(20003, 'I want to get AWS Certified', 10002);

insert into post(id, description, user_id)
values(20004, 'I want to learn Cloud', 10003);