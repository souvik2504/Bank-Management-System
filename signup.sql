create database bankmanagementsystem;
use bankmanagementsystem;
create table signup(Form_no varchar(20), Name Varchar(20), Fathers_Name varchar(20), DOB varchar(20), Gender varchar(20), Email varchar(20), Maretial_Status varchar(20), Addres varchar(150), City varchar(20), State varchar(20), PIN_Code varchar(25), primary key(Form_no)); 

select*from signup;

select * from signup;
use bankmanagementsystem;
create table signuptwo(Form_No varchar(20), Religion varchar(20), Catagory varchar(20), Income varchar(20), Education varchar(20), Occupation varchar(20), PAN_No varchar(20), Aadhar_No varchar(20), Senior_Citizen varchar(20), Existing_Account varchar(20), primary key(Form_No));
alter table signuptwo drop primary key;
create table signupthree(Form_No varchar(20), Account_Type varchar(20), Card_no varchar(40), PIN_NO varchar(20), Ficility varchar(100));

show tables;
select*from signupthree;

create table login(Form_NO varchar(20), Card_Number varchar(40), PIN_Number varchar(20)); 
create table bank(Pin varchar(20), Date varchar(50), Transaction_Type varchar(100), Amount varchar(30));