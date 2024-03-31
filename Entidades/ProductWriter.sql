CREATE TABLE ProductWriter (
    id_productWriter    NUMBER(8),
    id_product          NUMBER(8),
    id_writer           NUMBER(8)
);

CREATE SEQUENCE s_productWriter
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ProductWriter
    ADD
    CONSTRAINT pk_productWriter PRIMARY KEY (id_productWriter)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE ProductWriter
    ADD
    CONSTRAINT fk_productWriter_product FOREIGN KEY (id_product) 
    REFERENCES Product(id_product);

ALTER TABLE ProductWriter
    ADD
    CONSTRAINT fk_productWriter_writer FOREIGN KEY (id_writer) 
    REFERENCES Writer(id_writer);