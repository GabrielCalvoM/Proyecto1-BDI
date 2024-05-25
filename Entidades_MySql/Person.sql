CREATE TABLE person (
    id_person       INT AUTO_INCREMENT,
    first_name      VARCHAR(20) NOT NULL,
    last_name       VARCHAR(20) NOT NULL,
    birth_date      DATE,
    height_artist   INT NOT NULL,
    id_gender       INT NOT NULL,
    CONSTRAINT person_firstName_nn CHECK (first_name IS NOT NULL),
    CONSTRAINT person_lastName_nn CHECK (last_name IS NOT NULL),
    CONSTRAINT person_height_nn CHECK (height_artist IS NOT NULL),
    CONSTRAINT person_idGender_nn CHECK (id_gender IS NOT NULL),
    PRIMARY KEY (id_person)
);

ALTER TABLE person
    ADD CONSTRAINT fk_person_gender FOREIGN KEY (id_gender) REFERENCES gender(id_gender);
    