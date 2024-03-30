CREATE TABLE accountType (
    id_accountType  NUMBER(6),
    name            VARCHAR(20) CONSTRAINT accountType_name_nn NOT NULL
);

CREATE SEQUENCE s_accountType
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;

ALTER TABLE accountType
    ADD
    CONSTRAINT pk_accountType PRIMARY KEY (id_accountType)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);