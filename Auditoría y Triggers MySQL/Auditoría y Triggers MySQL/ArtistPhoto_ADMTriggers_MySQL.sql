-- CAMPOS DE AUDITORIA: ArtistPhoto
ALTER TABLE ArtistPhoto
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ArtistPhoto
-- Trigger Insert on ArtistPhoto
DELIMITER //

CREATE TRIGGER before_insert_ArtistPhoto
BEFORE INSERT ON ArtistPhoto
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ArtistPhoto
DELIMITER //

CREATE TRIGGER before_update_ArtistPhoto
BEFORE UPDATE ON ArtistPhoto
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;