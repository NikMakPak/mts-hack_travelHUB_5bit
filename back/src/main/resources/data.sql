
insert into roles(name) values ('ADMIN');
insert into roles(name) values ('MANAGER');
insert into roles(name) values ('ACCOUNTING');
insert into roles(name) values ('SQUAD');
insert into roles(name) values ('USER');

insert into squads(name) values ('DEVELOPMENT');
insert into squads(name) values ('HR');
insert into squads(name) values ('SMM');

insert into squads(name) values ('DEVELOPMENT');
insert into squads(name) values ('HR');
insert into squads(name) values ('SMM');

insert into status_codes(code, name) values ('1', 'Bid created');
insert into status_codes(code, name) values ('2', 'Bid was firstly approved by SQUAD');
insert into status_codes(code, name) values ('3', 'Bid was firstly rejected by SQUAD');
insert into status_codes(code, name) values ('4', 'Bid was firstly approved by MANAGER');
insert into status_codes(code, name) values ('5', 'Bid firstly was approved by ACCOUNTING');
insert into status_codes(code, name) values ('6', 'Bid firstly was rejected by ACCOUNTING');
insert into status_codes(code, name) values ('7', 'Bid was secondly approved by SQUAD');
insert into status_codes(code, name) values ('8', 'Bid was secondly rejected by SQUAD');
insert into status_codes(code, name) values ('9', 'Bid was secondly approved by MANAGER');
insert into status_codes(code, name) values ('10', 'Trip active');
insert into status_codes(code, name) values ('11', 'Trip ended');
insert into status_codes(code, name) values ('12', 'ACCOUNTING create report');


insert into users(email, grade, password, user_role) values ('admin@admin',3, '$2a$12$8AiPlUiGLsSTCOynrwbDL.2cA6SfI537qEf8vf6rTWdzVhdS.ACI2',1);
