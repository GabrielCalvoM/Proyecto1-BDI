CREATE TABLE nationality (
    id_nationality  NUMBER(10),
    id_person       NUMBER(10)  CONSTRAINT nationality_idPerson_nn NOT NULL,
    id_country      NUMBER(3)   CONSTRAINT nationality_idCountry_nn NOT NULL
);

CREATE SEQUENCE s_nationality
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE nationality
    ADD
    CONSTRAINT pk_nationality PRIMARY KEY (id_nationality)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE nationality
    ADD
    CONSTRAINT fk_nationality_person FOREIGN KEY (id_person) REFERENCES person(id_person);
    
ALTER TABLE nationality
    ADD
    CONSTRAINT fk_nationality_country FOREIGN KEY (id_country) REFERENCES country(id_country);