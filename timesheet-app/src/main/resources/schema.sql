DROP TABLE  IF EXISTS  timesheet;

CREATE TABLE IF NOT EXISTS timesheet (id bigint PRIMARY KEY auto_increment, timesheet_date varchar(255), employee_id bigint, hours bigint);
