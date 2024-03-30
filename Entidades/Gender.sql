CREATE TABLE gender (
    id_gender       NUMBER(1),
    name            VARCHAR2(10) CONSTRAINT gender_name_nn NOT NULL
);

ALTER TABLE gender
    ADD
    CONSTRAINT pk_gender PRIMARY KEY (id_gender)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);