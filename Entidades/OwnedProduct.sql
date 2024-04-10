CREATE TABLE ownedProduct (
    id_ownedproduct         NUMBER(10),
    id_product              NUMBER(6) CONSTRAINT ownedproduct_idProduct_nn NOT NULL,
    id_user                 NUMBER(6) CONSTRAINT ownedproduct_idWishlist_nn NOT NULL,
    date_bought             DATE DEFAULT SYSDATE CONSTRAINT ownedProduct_dateBought_nn NOT NULL 
);

CREATE SEQUENCE s_ownedProduct
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ownedProduct
    ADD
    CONSTRAINT pk_ownedProduct PRIMARY KEY (id_ownedProduct)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE ownedProduct
    ADD
    CONSTRAINT fk_ownedProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE ownedProduct
    ADD
    CONSTRAINT fk_ownedProduct_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);