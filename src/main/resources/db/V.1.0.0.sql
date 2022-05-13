CREATE TABLE IF NOT EXISTS Products (
  id CHAR(32) NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT NULL,
  price float NOT NULL,
  PRIMARY KEY PRODUCT_PK (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO Products (id, name, description, price) VALUES ('8410E3F957D54873AFA28ADA1B0F2156', 'Teste de produto', 'Este produto é um teste', 29.90);
