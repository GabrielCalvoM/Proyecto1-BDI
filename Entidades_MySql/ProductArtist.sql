CREATE TABLE ProductArtist (
    id_productArtist              INT AUTO_INCREMENT,
    id_product                    INT NOT NULL,
    id_artist                     INT NOT NULL,
    CONSTRAINT productArtist_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT productArtist_idArtist_nn CHECK (id_artist IS NOT NULL),
    PRIMARY KEY (id_productArtist)
);

ALTER TABLE ProductArtist
    ADD CONSTRAINT fk_productArtist_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_productArtist_artist FOREIGN KEY (id_artist) REFERENCES Artist(id_artist);
