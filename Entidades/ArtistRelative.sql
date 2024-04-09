CREATE TABLE ArtistRelative (
    id_artistRelative   NUMBER(8),
    id_artist           NUMBER(8),
    id_relative         NUMBER(8),
    id_relationType     NUMBER(8)
);

CREATE SEQUENCE s_ArtistRelative
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ArtistRelative
    ADD
    CONSTRAINT pk_artistRelative PRIMARY KEY (id_artistRelative)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE ArtistRelative
    ADD
    CONSTRAINT fk_artistRelative_artist FOREIGN KEY (id_artist) 
    REFERENCES Artist(id_artist);

ALTER TABLE ArtistRelative
    ADD
    CONSTRAINT fk_artistRelative_relative FOREIGN KEY (id_relative) 
    REFERENCES Person(id_person);
    
ALTER TABLE ArtistRelative
    ADD
    CONSTRAINT fk_artistRelative_relationType FOREIGN KEY (id_relationType) 
    REFERENCES RelativeType(id_relativeType);