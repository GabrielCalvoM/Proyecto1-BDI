CREATE TABLE identificationType (
    id_type         INT AUTO_INCREMENT,
    name            VARCHAR(15) NOT NULL,
    CONSTRAINT identificationType_name_nn CHECK (name IS NOT NULL),
    PRIMARY KEY (id_type)
);