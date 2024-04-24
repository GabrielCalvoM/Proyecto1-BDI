CREATE TABLE ArtistType (
    id_artistType       NUMBER(8),
    name_type           VARCHAR(3000) CONSTRAINT artistType_name_nn NOT NULL
);

CREATE SEQUENCE s_ArtistType
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;


ALTER TABLE ArtistType
    ADD
    CONSTRAINT pk_artistType PRIMARY KEY (id_artistType)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);