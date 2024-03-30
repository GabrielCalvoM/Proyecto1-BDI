CREATE TABLE productOnCatalogue (
    id_productOnCatalogue   NUMBER(10),
    id_product              NUMBER(6) CONSTRAINT prodCatalogue_idProduct_nn NOT NULL,
    id_catalogue            NUMBER(6) CONSTRAINT prodCatalogue_idCatalogue_nn NOT NULL
);

CREATE SEQUENCE s_productOnCatalogue
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE productOnCatalogue
    ADD
    CONSTRAINT pk_prodCatalogue PRIMARY KEY (id_productOnCatalogue)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE productOnCatalogue
    ADD
    CONSTRAINT fk_prodCatalogue_product FOREIGN KEY (id_product) REFERENCES product(id_product);
    
ALTER TABLE productOnCatalogue
    ADD
    CONSTRAINT fk_prodCatalogue_catalogue FOREIGN KEY (id_catalogue) REFERENCES catalogue(id_catalogue);