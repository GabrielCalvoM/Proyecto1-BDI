CREATE TABLE catalogue (
    id_catalogue    INT AUTO_INCREMENT,
    name            VARCHAR(20) NOT NULL,
    CONSTRAINT catalogue_name_nn CHECK (name IS NOT NULL),
    PRIMARY KEY (id_catalogue)
);