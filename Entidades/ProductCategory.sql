CREATE TABLE productCategory (
    id_productCategory  NUMBER(8),
    id_product          NUMBER(6) CONSTRAINT productCategory_idProduct_nn NOT NULL,
    id_category         NUMBER(4) CONSTRAINT productCategory_idCategory_nn NOT NULL
);

CREATE SEQUENCE s_productCategory
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;

ALTER TABLE productCategory
    ADD
    CONSTRAINT pk_productCategory PRIMARY KEY (id_productCategory)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE productCategory
    ADD
    CONSTRAINT fk_productCategory_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE productCategory
    ADD
    CONSTRAINT fk_productCategory_category FOREIGN KEY (id_category) REFERENCES category(id_category);