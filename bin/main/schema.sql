CREATE TABLE customer (
	id BIGINT not null auto_increment,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	mobile_number varchar(15) not null
);
ALTER TABLE customer ADD CONSTRAINT customer_uk1 UNIQUE (mobile_number);
ALTER TABLE customer ADD CONSTRAINT customer_uk1_pk PRIMARY KEY(id); 
