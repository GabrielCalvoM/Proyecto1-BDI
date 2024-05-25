-- CAMPOS DE AUDITORIA: Series
ALTER TABLE Series
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Series
-- Trigger Insert on Series
DELIMITER //

CREATE TRIGGER before_insert_Series
BEFORE INSERT ON Series
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Series
DELIMITER //

CREATE TRIGGER before_update_Series
BEFORE UPDATE ON Series
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;