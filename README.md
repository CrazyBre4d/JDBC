# JDBC-based program

JDBC
----------

SQL-code 


CREATE TABLE userss
(
id NUMBER PRIMARY KEY,
f_name VARCHAR(20) ,
l_name VARCHAR(20),
role_id NUMBER,
loginn VARCHAR(20),
passwordd VARCHAR(32),

CONSTRAINT fk_rolee 
FOREIGN KEY (id)
REFERENCES roless(id)
);

CREATE TABLE roless (
id NUMBER PRIMARY KEY,
role_name VARCHAR(20));


CREATE TABLE orders(
id1 NUMBER PRIMARY KEY,
user_id NUMBER,
product_id NUMBER, 
is_ordered INT,
purchase_date DATE,

CONSTRAINT fk_user_id1
FOREIGN KEY (id1)
REFERENCES userss(ID),

CONSTRAINT fk_product_id
FOREIGN KEY (id1)
REFERENCES product(id)
);

CREATE TABLE product(
id NUMBER PRIMARY KEY,
product_name VARCHAR(20),
product_price DECIMAL,
product_description VARCHAR(300),
type_id NUMBER,

CONSTRAINT fk_type_id
FOREIGN KEY (id)
REFERENCES product_type(id)

);
CREATE TABLE product_type(
id NUMBER PRIMARY KEY,
type_name VARCHAR(20)
);

CREATE OR REPLACE VIEW FORUSER AS
SELECT  u.loginn, u.f_name, p.product_name, p.product_description, p.product_price, o.is_ordered, o.id1, o.purchase_date
FROM userss u
JOIN orders o ON u.id = o.id1
JOIN product p ON o.product_id = p.id;

 CREATE SEQUENCE myseq
  START WITH 10  
  INCREMENT BY 1; 
