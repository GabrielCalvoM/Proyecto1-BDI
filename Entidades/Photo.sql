CREATE TABLE photo (
    id_photo        NUMBER(8),
    picture         BFILE       CONSTRAINT photo_picture_nn NOT NULL
);

CREATE SEQUENCE s_photo
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 8000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE photo
    ADD
    CONSTRAINT pk_photo PRIMARY KEY (id_photo)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);