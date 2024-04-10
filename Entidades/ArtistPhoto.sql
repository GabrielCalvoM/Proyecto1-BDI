CREATE TABLE ArtistPhoto (
    id_photo        NUMBER(8),
    id_artist       NUMBER(6) CONSTRAINT artistPhoto_idArtist_mm NOT NULL
);

ALTER TABLE ArtistPhoto
    ADD
    CONSTRAINT pk_artistPhoto PRIMARY KEY (id_photo)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE ArtistPhoto
    ADD
    CONSTRAINT fk_artistPhoto_photo FOREIGN KEY (id_photo) REFERENCES Photo(id_photo);
    
ALTER TABLE ArtistPhoto
    ADD
    CONSTRAINT fk_ArtistPhoto_artist FOREIGN KEY (id_artist) REFERENCES Artist(id_artist);