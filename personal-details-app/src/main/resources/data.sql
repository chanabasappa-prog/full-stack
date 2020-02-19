DROP TABLE  IF EXISTS  personaldetail;

CREATE TABLE IF NOT EXISTS personaldetail (id bigint PRIMARY KEY auto_increment, name varchar(255));

insert into personaldetail values (1, 'Home');
insert into personaldetail values (2, 'Office');


