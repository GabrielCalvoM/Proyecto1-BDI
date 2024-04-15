CREATE TABLE district (
    id_district     NUMBER(8),
    name            VARCHAR2(20)    CONSTRAINT district_name_nn NOT NULL,
    id_canton       NUMBER(8)       CONSTRAINT district_idCanton_nn NOT NULL
);

CREATE SEQUENCE s_district
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;

ALTER TABLE district
    ADD
    CONSTRAINT pk_district PRIMARY KEY (id_district)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE district
    ADD
    CONSTRAINT fk_district_canton FOREIGN KEY (id_canton) REFERENCES canton(id_canton);