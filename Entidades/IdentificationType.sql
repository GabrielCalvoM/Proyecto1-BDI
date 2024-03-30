CREATE TABLE identificationType (
    id_type         NUMBER(2),
    name            VARCHAR2(15) CONSTRAINT identificationType_name_nn NOT NULL
);

CREATE SEQUENCE s_identificationType
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100
    NOCACHE
    NOCYCLE;

ALTER TABLE identificationType
    ADD
    CONSTRAINT pk_identificationType PRIMARY KEY (id_type)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);