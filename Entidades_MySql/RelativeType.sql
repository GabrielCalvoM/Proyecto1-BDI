CREATE TABLE RelativeType (
    id_relativeType     INT AUTO_INCREMENT,
    name_relativeType   VARCHAR(15) NOT NULL,
    CONSTRAINT relativeType_name_nn CHECK (name_relativeType IS NOT NULL),
    PRIMARY KEY (id_relativeType)
);