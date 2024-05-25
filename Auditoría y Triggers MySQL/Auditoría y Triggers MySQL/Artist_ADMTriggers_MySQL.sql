-- CAMPOS DE AUDITORIA: Artist
ALTER TABLE Artist
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Artist
-- Trigger Insert on Artist
DELIMITER //

CREATE TRIGGER before_insert_Artist
BEFORE INSERT ON Artist
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Artist
DELIMITER //

CREATE TRIGGER before_update_Artist
BEFORE UPDATE ON Artist
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;