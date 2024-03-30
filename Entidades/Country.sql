CREATE TABLE country (
    id_country      NUMBER(3),
    name            VARCHAR2(20) CONSTRAINT country_name_nn NOT NULL
);

CREATE SEQUENCE s_country
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 300
    NOCACHE
    NOCYCLE;

ALTER TABLE country
    ADD
    CONSTRAINT pk_country PRIMARY KEY (id_country)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);