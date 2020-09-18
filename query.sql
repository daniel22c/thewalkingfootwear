create table categories(
category_id int not null auto_increment, 
category_name varchar(30),
primary key(category_id));

create table products(
prod_id int not null auto_increment,
prod_name varchar(30), 
category_id int, 
primary key(prod_id),
foreign key(category_id) references Categories(category_id)
on delete set null
on update cascade
);

insert into categories values(1, "Women's shoes");
insert into categories values(2, "Men's shoes");
insert into categories values(3, "Girl's shoes");
insert into categories values(4, "Boys's shoes");
insert into categories values(5, "Accessories");

insert into products values (1, 1,"prod1");
insert into products values (2, 2,"prod2");
insert into products values (3, 3,"prod3");
insert into products values (4, 4,"prod4");
insert into products values (5, 5,"prod5");