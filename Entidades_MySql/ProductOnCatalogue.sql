CREATE TABLE productOnCatalogue (
    id_productOnCatalogue   INT AUTO_INCREMENT,
    id_product              INT NOT NULL,
    id_catalogue            INT NOT NULL,
    CONSTRAINT prodCatalogue_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT prodCatalogue_idCatalogue_nn CHECK (id_catalogue IS NOT NULL),
    PRIMARY KEY (id_productOnCatalogue)
);

ALTER TABLE productOnCatalogue
    ADD CONSTRAINT fk_prodCatalogue_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_prodCatalogue_catalogue FOREIGN KEY (id_catalogue) REFERENCES catalogue(id_catalogue);
