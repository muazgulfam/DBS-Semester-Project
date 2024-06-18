CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

CREATE TABLE signup
	(
		formno varchar(20),
        name varchar(25),
        father_name varchar(25),
        dob varchar(20),
        gender varchar(20),
        email varchar(30),
        marital_status varchar(20),
        address varchar(40),
        city varchar(25),
        state varchar(20),
        pin_code varchar(20)
    );
    
    SELECT * from signup;
    SHOW tables;
    
    
CREATE TABLE AccDetails
	(
		formno varchar(20),
		accountType varchar(40),
		cardNumber varchar(25),
		pin varchar(10),
		facility varchar(100)
	);

SELECT * from AccDetails;

CREATE TABLE login
	(
		formno varchar(20),
		cardNumber varchar(25),
		pin varchar(10)
	);
    
SELECT * from login;