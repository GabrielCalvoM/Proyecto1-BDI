CREATE TABLE ViewedProduct (
    id_viewedProduct        NUMBER(10),
    id_product              NUMBER(6) CONSTRAINT ViewedProduct_idProduct_nn NOT NULL,
    id_user                 NUMBER(6) CONSTRAINT ViewedProduct_idUser_nn NOT NULL
);

CREATE SEQUENCE s_viewedProduct
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ViewedProduct
    ADD
    CONSTRAINT pk_viewedProduct PRIMARY KEY (id_viewedProduct)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE viewedProduct
    ADD
    CONSTRAINT fk_viewedProduct_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE viewedProduct
    ADD
    CONSTRAINT fk_viewedProduct_user FOREIGN KEY (id_user) REFERENCES SysUser(id_user);