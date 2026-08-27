DROP DATABASE IF EXISTS mydb0826;
CREATE DATABASE mydb0826;
USE mydb0826;

CREATE TABLE customer(
    no int AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(30),
    people int
);

insert into customer(phone, people) VALUES ("010-1111-1111", 4),("010-2222-2222", 1);
