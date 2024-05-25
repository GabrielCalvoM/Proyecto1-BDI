CREATE TABLE productCategory (
    id_productCategory  INT AUTO_INCREMENT,
    id_product          INT NOT NULL,
    id_category         INT NOT NULL,
    CONSTRAINT productCategory_idProduct_nn CHECK (id_product IS NOT NULL),
    CONSTRAINT productCategory_idCategory_nn CHECK (id_category IS NOT NULL),
    PRIMARY KEY (id_productCategory)
);

ALTER TABLE productCategory
    ADD CONSTRAINT fk_productCategory_product FOREIGN KEY (id_product) REFERENCES product(id_product),
    ADD CONSTRAINT fk_productCategory_category FOREIGN KEY (id_category) REFERENCES category(id_category);
