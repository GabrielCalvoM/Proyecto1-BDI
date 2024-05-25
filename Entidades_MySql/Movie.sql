CREATE TABLE Movie (
    id_movie    INT AUTO_INCREMENT,
    id_product INT,
    duration_movie INT,
    PRIMARY KEY (id_movie)
);

ALTER TABLE Movie
    ADD CONSTRAINT fk_movie_product FOREIGN KEY (id_product) REFERENCES Product(id_product);