-- CAMPOS DE AUDITORIA: District
ALTER TABLE District
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: District
-- Trigger Insert on District
DELIMITER //

CREATE TRIGGER before_insert_District
BEFORE INSERT ON District
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on District
DELIMITER //

CREATE TRIGGER before_update_District
BEFORE UPDATE ON District
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;