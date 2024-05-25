CREATE TABLE country (
    id_country      INT AUTO_INCREMENT,
    name            VARCHAR(20) NOT NULL,
    CONSTRAINT country_name_nn CHECK (name IS NOT NULL),
    PRIMARY KEY (id_country)
);