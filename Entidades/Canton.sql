CREATE TABLE canton (
    id_canton       NUMBER(8),
    name            VARCHAR2(20) CONSTRAINT canton_name_nn NOT NULL,
    id_province     NUMBER(6) CONSTRAINT canton_idProvince_nn NOT NULL
);

ALTER TABLE canton
    ADD
    CONSTRAINT pk_canton PRIMARY KEY (id_canton)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE canton
    ADD
    CONSTRAINT fk_canton_province FOREIGN KEY (id_province) REFERENCES province(id_province);