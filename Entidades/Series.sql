CREATE TABLE Series (
    id_series    NUMBER(8),
    name_series  VARCHAR(70) CONSTRAINT series_name_nn NOT NULL,
    id_product  NUMBER(8) CONSTRAINT series_idProduct_nn NOT NULL
);

CREATE SEQUENCE s_series
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE Series
    ADD
    CONSTRAINT pk_series PRIMARY KEY (id_series)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Series
    ADD
    CONSTRAINT fk_series_product FOREIGN KEY (id_product) REFERENCES Product(id_product);