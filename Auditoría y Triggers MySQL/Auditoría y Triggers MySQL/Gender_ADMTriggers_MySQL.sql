-- CAMPOS DE AUDITORIA: Gender
ALTER TABLE Gender
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Gender
-- Trigger Insert on Gender
DELIMITER //

CREATE TRIGGER before_insert_Gender
BEFORE INSERT ON Gender
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Gender
DELIMITER //

CREATE TRIGGER before_update_Gender
BEFORE UPDATE ON Gender
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;