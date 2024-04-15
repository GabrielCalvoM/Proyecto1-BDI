CREATE TABLE RelativeType (
    id_relativeType     NUMBER(8),
    name_relativeType   VARCHAR(15) CONSTRAINT relativeType_name_nn NOT NULL
);

CREATE SEQUENCE s_RelativeType 
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000
    NOCACHE
    NOCYCLE;
    

ALTER TABLE RelativeType
    ADD
    CONSTRAINT pk_relativeType PRIMARY KEY (id_relativeType)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);