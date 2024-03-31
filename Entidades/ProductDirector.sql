CREATE TABLE ProductDirector (
    id_productDirector    NUMBER(8),
    id_product          NUMBER(8),
    id_director           NUMBER(8)
);

CREATE SEQUENCE s_productDirector
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ProductDirector
    ADD
    CONSTRAINT pk_productDirector PRIMARY KEY (id_productDirector)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE ProductDirector
    ADD
    CONSTRAINT fk_productDirector_product FOREIGN KEY (id_product) 
    REFERENCES Product(id_product);

ALTER TABLE ProductDirector
    ADD
    CONSTRAINT fk_productDirector_director FOREIGN KEY (id_director) 
    REFERENCES Director(id_director);