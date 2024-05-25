CREATE TABLE productPhoto (
    id_productPhoto INT,
    id_product      INT NOT NULL,
    CONSTRAINT productPhoto_idProduct_mm CHECK (id_product IS NOT NULL),
    PRIMARY KEY (id_productPhoto),
    CONSTRAINT fk_productPhoto_photo FOREIGN KEY (id_productPhoto) REFERENCES photo(id_photo),
    CONSTRAINT fk_productPhoto_product FOREIGN KEY (id_product) REFERENCES product(id_product)
);