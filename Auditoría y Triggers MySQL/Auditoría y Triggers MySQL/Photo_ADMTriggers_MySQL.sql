-- CAMPOS DE AUDITORIA: Photo
ALTER TABLE Photo
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Photo
-- Trigger Insert on Photo
DELIMITER //

CREATE TRIGGER before_insert_Photo
BEFORE INSERT ON Photo
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Photo
DELIMITER //

CREATE TRIGGER before_update_Photo
BEFORE UPDATE ON Photo
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;