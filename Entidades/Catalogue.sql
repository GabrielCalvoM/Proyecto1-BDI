CREATE TABLE catalogue (
    id_catalogue    NUMBER(6),
    name            VARCHAR(20) CONSTRAINT catalogue_name_nn NOT NULL
);

CREATE SEQUENCE s_catalogue
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;

ALTER TABLE catalogue
    ADD
    CONSTRAINT pk_catalogue PRIMARY KEY (id_catalogue)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);