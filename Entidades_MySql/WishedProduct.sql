CREATE TABLE wishedProduct (
    id_wishedproduct        INT AUTO_INCREMENT,
    id_product              INT NOT NULL,
    id_wishlist             INT NOT NULL,
    CONSTRAINT wishedproduct_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT wishedproduct_idWishlist_nn CHECK (id_wishlist IS NOT NULL),
    PRIMARY KEY (id_wishedproduct)
);

ALTER TABLE wishedProduct
    ADD CONSTRAINT fk_wishedProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_wishedProduct_wishlist FOREIGN KEY (id_wishlist) REFERENCES wishlist(id_wishlist);
