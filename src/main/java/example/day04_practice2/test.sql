DROP DATABASE IF EXISTS mydb0902_practice;
CREATE DATABASE mydb0902_practice;
use mydb0902_practice;
create table test(
    no INT AUTO_INCREMENT PRIMARY KEY ,
    content VARCHAR(255),
    writer VARCHAR(255)
);
 
 insert into test ( content, writer )VALUES("졸려", "김두현1");
 insert into test ( content, writer )VALUES("집에 가고싶어", "김두현2");
 insert into test ( content, writer )VALUES("자고싶어", "김두현3");