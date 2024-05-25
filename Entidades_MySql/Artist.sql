CREATE TABLE Artist (
    id_artist           INT AUTO_INCREMENT,
    id_ArtistType       INT NOT NULL,
    biography_artist    VARCHAR(3000) NOT NULL,
    trivia_data         VARCHAR(1000) NOT NULL,
    CONSTRAINT artist_type_nn CHECK (id_ArtistType IS NOT NULL),
    CONSTRAINT artist_biography_nn CHECK (biography_artist IS NOT NULL),
    CONSTRAINT artist_triviaData_nn CHECK (trivia_data IS NOT NULL),
    PRIMARY KEY (id_artist)
);

ALTER TABLE Artist
    ADD CONSTRAINT fk_artist_person FOREIGN KEY (id_artist) REFERENCES Person(id_person),
    ADD CONSTRAINT fk_artist_type FOREIGN KEY (id_ArtistType) REFERENCES ArtistType(id_ArtistType);
