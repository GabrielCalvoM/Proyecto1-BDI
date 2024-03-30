CREATE TABLE country (
    id_country      NUMBER(3),
    name            VARCHAR2(20) CONSTRAINT country_name_nn NOT NULL
);

ALTER TABLE country
    ADD
    CONSTRAINT pk_country PRIMARY KEY (id_country)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);