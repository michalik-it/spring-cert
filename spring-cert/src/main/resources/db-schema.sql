DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
	id INT primary key not NULL,
	name varchar(100) NULL,
	amount INT NULL
);