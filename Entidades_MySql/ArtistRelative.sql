CREATE TABLE ArtistRelative (
    id_artistRelative   INT AUTO_INCREMENT,
    id_artist           INT NOT NULL,
    id_relative         INT NOT NULL,
    id_relationType     INT NOT NULL,
    PRIMARY KEY (id_artistRelative)
);

ALTER TABLE ArtistRelative
    ADD CONSTRAINT fk_artistRelative_artist FOREIGN KEY (id_artist) REFERENCES Artist(id_artist),
    ADD CONSTRAINT fk_artistRelative_relative FOREIGN KEY (id_relative) REFERENCES Person(id_person),
    ADD CONSTRAINT fk_artistRelative_relationType FOREIGN KEY (id_relationType) REFERENCES RelativeType(id_relativeType);
