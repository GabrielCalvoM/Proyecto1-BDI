CREATE TABLE cartProduct (
    id_cartproduct          NUMBER(10),
    id_product              NUMBER(6) CONSTRAINT cartproduct_idProduct_nn NOT NULL,
    id_shoppingCart         NUMBER(6) CONSTRAINT cartproduct_idShoppingCart_nn NOT NULL
);

CREATE SEQUENCE s_cartProduct
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE cartProduct
    ADD
    CONSTRAINT pk_cartProduct PRIMARY KEY (id_cartProduct)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE cartProduct
    ADD
    CONSTRAINT fk_cartProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE cartProduct
    ADD
    CONSTRAINT fk_cartProduct_shoppingCart FOREIGN KEY (id_shoppingCart) REFERENCES shoppingCart(id_shoppingCart);