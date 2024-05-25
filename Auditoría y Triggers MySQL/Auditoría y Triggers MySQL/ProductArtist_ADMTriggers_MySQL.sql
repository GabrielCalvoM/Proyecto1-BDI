-- CAMPOS DE AUDITORIA: ProductArtist
ALTER TABLE ProductArtist
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ProductArtist
-- Trigger Insert on ProductArtist
DELIMITER //

CREATE TRIGGER before_insert_ProductArtist
BEFORE INSERT ON ProductArtist
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ProductArtist
DELIMITER //

CREATE TRIGGER before_update_ProductArtist
BEFORE UPDATE ON ProductArtist
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;