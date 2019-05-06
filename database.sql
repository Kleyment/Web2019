DROP DATABASE peucher;
CREATE OR REPLACE DATABASE peucher
  CHARACTER SET = 'utf8mb4'
  COLLATE = 'utf8mb4_unicode_ci';
USE peucher;

CREATE OR REPLACE TABLE products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  price DOUBLE NOT NULL,
  image VARCHAR(45),
  description VARCHAR(500),
  PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  pseudo varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  hashcart varchar(100) DEFAULT NULL,
  salt varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE cart (
  hashcart varchar(100) DEFAULT NULL,
  iditem INT NULL,
  PRIMARY KEY (hashcart, iditem),
  FOREIGN KEY (iditem) REFERENCES products (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO products (name, price, image, description) VALUES ("Razer Naga",80.0,"razer_naga.jpg", " Retro-Eclairage RGB Souris Gaming Mouse MMO Ergonomique, 19 Boutons Programmables & 16.000 dpi");
INSERT INTO products (name, price, image, description) VALUES ("LDLC Fox Meca Red",99.95,"ldlc_fox_meca_red.jpg", "Le Fox Meca Red par LDLC se destine aux gamers qui souhaitent un clavier mécanique rétroéclairé RGB avec des switches Cherry MX RED linéaires et réactifs et disposant de nombreux atouts pour accéder à la victoire. Macros à la volée, anti-ghosting intégral, Polling Rate à 1000 Hz, rien ne manque !");
INSERT INTO products (name, price, image, description) VALUES ("Corsair K70 LUX RGB",126.01,"corsair_k70.jpg", "Clavier Mécanique Gaming (Cherry MX Brown: Tactile et silencieux, Rétro-Éclairage RGB Multicolore, AZERTY FR Layout) - Noir");
INSERT INTO products (name, price, image, description) VALUES ("Logitech G633",103.99, "logitech_g633.jpg", "Logitech, casque gaming G633 Artemis Spectrum Pro filaire, son surround Dolby 7.1 pour PC Xbox One PS4, microphone à réduction de bruit entièrement personnalisable, LIGHTSYNC RVB, Noir");
INSERT INTO cart (hashcart, iditem) VALUES ("AD9C625B1857E2CB0F7F04BCA9134BFD371C5D02CF29E97C99346127C144FF38",3);
INSERT INTO cart (hashcart, iditem) VALUES ("AD9C625B1857E2CB0F7F04BCA9134BFD371C5D02CF29E97C99346127C144FF38",4);
INSERT INTO users (pseudo, password, role, hashcart, salt) values ("admin", "admin", "admin", "434960816100FA9749AC6F4BB8AF8F580AC24E1F1C78B0DDB72978E5CDFBF792", "88C179D58E4AEE0596056BB73BE32834952FD53F");
INSERT INTO users (pseudo, password, role, hashcart, salt) values ("clem", "azerty", "user", "F22848EDA1EBB1A7E85493F24B4FD82156E667BB2150AB94D00F23CAA7985587", "4E3DEFDD23E59BC9DFA938CDB37ACB90EDFCD656");
INSERT INTO users (pseudo, password, role, hashcart, salt) values ("marvin", "formytho", "user", "AD9C625B1857E2CB0F7F04BCA9134BFD371C5D02CF29E97C99346127C144FF38", "4E47C0A61C797B3625D3BAED04D12775739FB20F");
