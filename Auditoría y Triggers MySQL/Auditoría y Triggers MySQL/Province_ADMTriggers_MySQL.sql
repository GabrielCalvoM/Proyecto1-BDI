-- CAMPOS DE AUDITORIA: Province
ALTER TABLE Province
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Province
-- Trigger Insert on Province
DELIMITER //

CREATE TRIGGER before_insert_Province
BEFORE INSERT ON Province
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Province
DELIMITER //

CREATE TRIGGER before_update_Province
BEFORE UPDATE ON Province
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;