-- CAMPOS DE AUDITORIA: ArtistRelative
ALTER TABLE ArtistRelative
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ArtistRelative
-- Trigger Insert on ArtistRelative
DELIMITER //

CREATE TRIGGER before_insert_ArtistRelative
BEFORE INSERT ON ArtistRelative
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ArtistRelative
DELIMITER //

CREATE TRIGGER before_update_ArtistRelative
BEFORE UPDATE ON ArtistRelative
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;