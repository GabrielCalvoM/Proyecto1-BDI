CREATE TABLE Series (
    id_series       INT AUTO_INCREMENT,
    name_series     VARCHAR(70) NOT NULL,
    id_product      INT NOT NULL,
    CONSTRAINT series_name_nn CHECK (name_series IS NOT NULL),
    CONSTRAINT series_idProduct_nn CHECK (id_product IS NOT NULL),
    PRIMARY KEY (id_series)
);

ALTER TABLE Series
    ADD CONSTRAINT fk_series_product FOREIGN KEY (id_product) REFERENCES Product(id_product);
