-- CAMPOS DE AUDITORIA: Episode
ALTER TABLE Episode
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Episode
-- Trigger Insert on Episode
DELIMITER //

CREATE TRIGGER before_insert_Episode
BEFORE INSERT ON Episode
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Episode
DELIMITER //

CREATE TRIGGER before_update_Episode
BEFORE UPDATE ON Episode
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;