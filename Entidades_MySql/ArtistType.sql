CREATE TABLE ArtistType (
    id_artistType       INT AUTO_INCREMENT,
    name_type           VARCHAR(30) NOT NULL,
    CONSTRAINT artistType_name_nn CHECK (name_type IS NOT NULL),
    PRIMARY KEY (id_artistType)
);