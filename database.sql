CREATE OR REPLACE DATABASE peucher;
USE peucher;

CREATE OR REPLACE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  pseudo varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  cart varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  price DOUBLE NOT NULL,
  image VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE cart (
  idcart INT NOT NULL,
  iditem INT NULL,
  PRIMARY KEY (idcart)
);

INSERT INTO users (pseudo, password, role) values ("admin", "admin", "admin	");
