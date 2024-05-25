CREATE SCHEMA `proy1`;

CREATE USER 'proy1'@'localhost' IDENTIFIED BY 'proy1';

GRANT ALL PRIVILEGES ON proy1.* TO 'proy1'@'localhost';