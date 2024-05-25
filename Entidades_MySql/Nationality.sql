CREATE TABLE nationality (
    id_nationality  INT AUTO_INCREMENT,
    id_person       INT NOT NULL,
    id_country      INT NOT NULL,
    CONSTRAINT nationality_idPerson_nn CHECK (id_person IS NOT NULL),
    CONSTRAINT nationality_idCountry_nn CHECK (id_country IS NOT NULL),
    PRIMARY KEY (id_nationality)
);

ALTER TABLE nationality
    ADD CONSTRAINT fk_nationality_person FOREIGN KEY (id_person) REFERENCES person(id_person),
    ADD CONSTRAINT fk_nationality_country FOREIGN KEY (id_country) REFERENCES country(id_country);
