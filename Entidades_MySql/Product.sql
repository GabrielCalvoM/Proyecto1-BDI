CREATE TABLE product (
    id_product      INT AUTO_INCREMENT,
    title           VARCHAR(50) NOT NULL,
    premiere_year   INT NOT NULL,
    synopsis        VARCHAR(300) NOT NULL,
    trailer         VARCHAR(200) NOT NULL,
    price           DECIMAL(10, 2),
    CONSTRAINT product_title_nn CHECK (title IS NOT NULL),
    CONSTRAINT product_premiereYear_nn CHECK (premiere_year IS NOT NULL),
    CONSTRAINT product_synopsis_nn CHECK (synopsis IS NOT NULL),
    CONSTRAINT product_trailer_nn CHECK (trailer IS NOT NULL),
    PRIMARY KEY (id_product)
);
