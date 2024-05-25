CREATE TABLE ownedProduct (
    id_ownedproduct         INT AUTO_INCREMENT,
    id_product              INT,
    id_user                 INT,
    date_bought             DATE,
    CONSTRAINT ownedproduct_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT ownedproduct_idUser_nn CHECK (id_user IS NOT NULL),
    CONSTRAINT ownedProduct_dateBought_nn CHECK (date_bought IS NOT NULL),
    PRIMARY KEY (id_ownedProduct)
);

ALTER TABLE ownedProduct
    ADD CONSTRAINT fk_ownedProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_ownedProduct_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);
