CREATE TABLE productPhoto (
    id_productPhoto NUMBER(8),
    id_photo        NUMBER(8),
    id_product      NUMBER(6) CONSTRAINT productPhoto_idProduct_mm NOT NULL
);

CREATE SEQUENCE s_productPhoto
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000
    NOCACHE
    NOCYCLE;

ALTER TABLE productPhoto
    ADD
    CONSTRAINT pk_productPhoto PRIMARY KEY (id_productPhoto)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE productPhoto
    ADD
    CONSTRAINT fk_productPhoto_photo FOREIGN KEY (id_photo) REFERENCES photo(id_photo);
    
ALTER TABLE productPhoto
    ADD
    CONSTRAINT fk_productPhoto_product FOREIGN KEY (id_product) REFERENCES product(id_product);