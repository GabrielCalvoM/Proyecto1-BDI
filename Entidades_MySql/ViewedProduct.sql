CREATE TABLE ViewedProduct (
    id_viewedProduct        INT AUTO_INCREMENT,
    id_product              INT NOT NULL,
    id_user                 INT NOT NULL,
    CONSTRAINT ViewedProduct_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT ViewedProduct_idUser_nn CHECK (id_user IS NOT NULL),
    PRIMARY KEY (id_viewedProduct)
);

ALTER TABLE ViewedProduct
    ADD CONSTRAINT fk_viewedProduct_product FOREIGN KEY (id_product) REFERENCES Product(id_product),
    ADD CONSTRAINT fk_viewedProduct_user FOREIGN KEY (id_user) REFERENCES SysUser(id_user);
