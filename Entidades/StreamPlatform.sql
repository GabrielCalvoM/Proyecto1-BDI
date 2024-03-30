CREATE TABLE streamPlatform (
    id_streamPlatform   NUMBER(5),
    name                VARCHAR2(20) CONSTRAINT streamPlatform_name_nn NOT NULL
);

CREATE SEQUENCE s_streamPlatform
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000
    NOCACHE
    NOCYCLE;

ALTER TABLE streamPlatform
    ADD
    CONSTRAINT pk_streamPlatform PRIMARY KEY (id_streamPlatform)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);