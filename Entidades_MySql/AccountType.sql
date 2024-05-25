CREATE TABLE accountType (
    id_accountType  INT AUTO_INCREMENT,
    name            VARCHAR(20) NOT NULL,
    CONSTRAINT accountType_name_nn CHECK (name IS NOT NULL),
    PRIMARY KEY (id_accountType)
);