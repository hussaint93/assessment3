create table account(
id int primary key auto_increment,
owner_name varchar(50) not null,
balance_amount long default(0),
created_date datetime default now(),
stats varchar(10),
acc_type varchar(20),
address varchar(200)
);

select * from account;



