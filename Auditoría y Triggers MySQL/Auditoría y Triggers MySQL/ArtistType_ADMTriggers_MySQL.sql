-- CAMPOS DE AUDITORIA: ArtistType
ALTER TABLE ArtistType
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ArtistType
-- Trigger Insert on ArtistType
DELIMITER //

CREATE TRIGGER before_insert_ArtistType
BEFORE INSERT ON ArtistType
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ArtistType
DELIMITER //

CREATE TRIGGER before_update_ArtistType
BEFORE UPDATE ON ArtistType
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;