drop table employee;
create table employee(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(25),
department_id int,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);


drop table department;
create table department(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(25),
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);


