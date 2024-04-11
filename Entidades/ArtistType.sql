CREATE TABLE ArtistType (
    id_artistType       NUMBER(8),
    name_type           VARCHAR(3000),
);

ALTER TABLE ArtistType
    ADD
    CONSTRAINT pk_artist PRIMARY KEY (id_artistType)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);