CREATE TABLE cartProduct (
    id_cartproduct          INT AUTO_INCREMENT,
    id_product              INT NOT NULL,
    id_shoppingCart         INT NOT NULL,
    CONSTRAINT cartproduct_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT cartproduct_idShoppingCart_nn CHECK (id_shoppingCart IS NOT NULL),
    PRIMARY KEY (id_cartProduct)
);

ALTER TABLE cartProduct
    ADD CONSTRAINT fk_cartProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_cartProduct_shoppingCart FOREIGN KEY (id_shoppingCart) REFERENCES ShoppingCart(id_shoppingCart);
