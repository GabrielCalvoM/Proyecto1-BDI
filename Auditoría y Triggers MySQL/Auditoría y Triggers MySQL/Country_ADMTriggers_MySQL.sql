-- CAMPOS DE AUDITORIA: Country
ALTER TABLE Country
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Country
-- Trigger Insert on Country
DELIMITER //

CREATE TRIGGER before_insert_Country
BEFORE INSERT ON Country
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Country
DELIMITER //

CREATE TRIGGER before_update_Country
BEFORE UPDATE ON Country
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;