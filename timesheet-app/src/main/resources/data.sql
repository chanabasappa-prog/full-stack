DROP TABLE  IF EXISTS  timesheet;

CREATE TABLE IF NOT EXISTS timesheet (id bigint PRIMARY KEY auto_increment, timesheet_date DATE DEFAULT CURRENT_TIMESTAMP, employee_id bigint, hours bigint);

insert into timesheet(timesheet_date,employee_id,hours) values(CURRENT_TIMESTAMP,2,8);
insert into timesheet(timesheet_date,employee_id,hours) values(CURRENT_TIMESTAMP,2,8);
insert into timesheet(timesheet_date,employee_id,hours) values(CURRENT_TIMESTAMP,2,8);
insert into timesheet(timesheet_date,employee_id,hours) values(CURRENT_TIMESTAMP,2,8);