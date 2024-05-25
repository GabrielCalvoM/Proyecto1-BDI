CREATE TABLE category (
    id_category     INT AUTO_INCREMENT,
    name            VARCHAR(15) NOT NULL,
    CONSTRAINT category_name_nn CHECK (name IS NOT NULL),
    CONSTRAINT uk_category_name UNIQUE(name),
    PRIMARY KEY (id_category)
);
