-- DROP TABLE productOnPlatform;

CREATE TABLE productOnPlatform (
    id_productOnPlatform    NUMBER(8),
    price                   NUMBER(5, 3) CONSTRAINT prodPlatform_price_nn NOT NULL,
    id_product              NUMBER(6) CONSTRAINT prodPlatform_idProduct_nn NOT NULL,
    id_streamPlatform       NUMBER(5) CONSTRAINT prodPlatform_idPlatform_nn NOT NULL
);

CREATE SEQUENCE s_productOnPlatform
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000
    NOCACHE
    NOCYCLE;

ALTER TABLE productOnPlatform
    ADD
    CONSTRAINT pk_prodPlatform PRIMARY KEY (id_productOnPlatform)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE productOnPlatform
    ADD
    CONSTRAINT fk_prodPlatform_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE productOnPlatform
    ADD
    CONSTRAINT fk_prodPlatform_streamPlatform FOREIGN KEY (id_streamPlatform) REFERENCES streamPlatform(id_streamPlatform);