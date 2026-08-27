create DATABASE mydb0826;

use mydb0813;

create TABLE customer(
    no int AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(30),
    people int
);

select * from customer;