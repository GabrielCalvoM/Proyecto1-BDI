-- CAMPOS DE AUDITORIA: Category
ALTER TABLE Category
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Category
-- Trigger Insert on Category
DELIMITER //

CREATE TRIGGER before_insert_Category
BEFORE INSERT ON Category
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Category
DELIMITER //

CREATE TRIGGER before_update_Category
BEFORE UPDATE ON Category
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;