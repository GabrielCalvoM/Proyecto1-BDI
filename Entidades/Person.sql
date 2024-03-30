CREATE TABLE person (
    id_person       NUMBER(10),
    first_name      VARCHAR2(20) CONSTRAINT person_firstName_nn NOT NULL,
    last_name       VARCHAR2(20) CONSTRAINT person_lastName_nn NOT NULL,
    birth_date      DATE DEFAULT SYSDATE CONSTRAINT person_birthDate_nn NOT NULL,
    id_gender       NUMBER(1) CONSTRAINT person_idGender_nn NOT NULL
);

CREATE SEQUENCE s_person
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 8000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE person
    ADD
    CONSTRAINT pk_person PRIMARY KEY (id_person)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE person
    ADD
    CONSTRAINT fk_person_gender FOREIGN KEY (id_gender) REFERENCES gender(id_gender);