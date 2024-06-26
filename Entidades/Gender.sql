CREATE TABLE gender (
    id_gender       NUMBER(1),
    name            VARCHAR2(10) CONSTRAINT gender_name_nn NOT NULL
);

CREATE SEQUENCE s_gender
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10
    NOCACHE
    NOCYCLE;

ALTER TABLE gender
    ADD
    CONSTRAINT pk_gender PRIMARY KEY (id_gender)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE gender
    ADD
    CONSTRAINT uk_gender_name UNIQUE(name);