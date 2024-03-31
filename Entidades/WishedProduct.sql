CREATE TABLE wishedProduct (
    id_wishedproduct        NUMBER(10),
    id_product              NUMBER(6) CONSTRAINT wishedproduct_idProduct_nn NOT NULL,
    id_wishlist             NUMBER(6) CONSTRAINT wishedproduct_idWishlist_nn NOT NULL
);

CREATE SEQUENCE s_wishedProduct
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE wishedProduct
    ADD
    CONSTRAINT pk_wishedProduct PRIMARY KEY (id_wishedProduct)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE wishedProduct
    ADD
    CONSTRAINT fk_wishedProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE wishedProduct
    ADD
    CONSTRAINT fk_wishedProduct_wishlist FOREIGN KEY (id_wishlist) REFERENCES wishlist(id_wishlist);