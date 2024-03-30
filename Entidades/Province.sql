CREATE TABLE province (
    id_province     NUMBER(6),
    name            VARCHAR2(20) CONSTRAINT province_name_nn NOT NULL,
    id_country      NUMBER(3) CONSTRAINT province_idCountry_nn NOT NULL
);

ALTER TABLE province
    ADD
    CONSTRAINT pk_province PRIMARY KEY (id_province)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE province
    ADD
    CONSTRAINT fk_province_country FOREIGN KEY (id_country) REFERENCES country(id_country);