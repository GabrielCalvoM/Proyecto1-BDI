CREATE TABLE product (
    id_product      NUMBER(8),
    title           VARCHAR2(30)    CONSTRAINT product_title_nn NOT NULL,
    premiere_year   NUMBER(4)       CONSTRAINT product_premiereYear_nn NOT NULL,
    synopsis        VARCHAR2(300)   CONSTRAINT product_synopsis_nn NOT NULL,
    trailer         VARCHAR2(200)   CONSTRAINT product_trailer_nn NOT NULL,
    price           NUMBER
);

CREATE SEQUENCE s_product
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;

ALTER TABLE product
    ADD
    CONSTRAINT pk_product PRIMARY KEY (id_product)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    