CREATE TABLE Artist (
    id_artist           NUMBER(8),
    id_ArtistType       NUMBER(8)       CONSTRAINT artist_type_nn NOT NULL,
    biography_artist    VARCHAR(3000)   CONSTRAINT artist_biography_nn NOT NULL,
    trivia_data         VARCHAR(1000)   CONSTRAINT artist_triviaData_nn NOT NULL
);

ALTER TABLE Artist
    ADD
    CONSTRAINT pk_artist PRIMARY KEY (id_artist)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Artist
    ADD
    CONSTRAINT fk_artist_person FOREIGN KEY (id_artist) REFERENCES Person(id_person);

ALTER TABLE Artist
    ADD
    CONSTRAINT fk_artist_type FOREIGN KEY (id_ArtistType) REFERENCES ArtistType(id_ArtistType);