CREATE TABLE ArtistPhoto (
    id_photo        INT,
    id_artist       INT NOT NULL,
    CONSTRAINT artistPhoto_idArtist_nn CHECK (id_artist IS NOT NULL),
    PRIMARY KEY (id_photo)
);

ALTER TABLE ArtistPhoto
    ADD CONSTRAINT fk_artistPhoto_photo FOREIGN KEY (id_photo) REFERENCES Photo(id_photo),
    ADD CONSTRAINT fk_ArtistPhoto_artist FOREIGN KEY (id_artist) REFERENCES Artist(id_artist);
