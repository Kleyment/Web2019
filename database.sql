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
  image VARCHAR(45),
  PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE cart (
  idcart INT NOT NULL,
  iditem INT NULL,
  PRIMARY KEY (idcart)
);

INSERT INTO users (pseudo, password, role) values ("admin", "admin", "admin");
INSERT INTO users (pseudo, password, role) values ("clem", "azerty", "user");
INSERT INTO users (pseudo, password, role) values ("marvin, "formytho", "user");
INSERT INTO products (name,price,image) VALUES ("Razer Naga",80.0,"razer_naga.jpg");
INSERT INTO products (name,price,image) VALUES ("LDLC Fox Meca Red",99.95,"ldlc_fox_meca_red.jpg");
