CREATE TABLE gender (
    id_gender       INT AUTO_INCREMENT,
    name            VARCHAR(10) NOT NULL,
    CONSTRAINT gender_name_nn CHECK (name IS NOT NULL),
    PRIMARY KEY (id_gender),
    CONSTRAINT uk_gender_name UNIQUE(name)
);