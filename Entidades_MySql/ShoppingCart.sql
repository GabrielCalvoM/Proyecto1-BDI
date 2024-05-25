CREATE TABLE ShoppingCart (
    id_shoppingcart      INT AUTO_INCREMENT,
    id_user              INT NOT NULL,
    CONSTRAINT shoppingCart_idUser_nn CHECK (id_user IS NOT NULL),
    PRIMARY KEY (id_shoppingcart)
);

ALTER TABLE ShoppingCart
    ADD CONSTRAINT fk_shoppingCart_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);
