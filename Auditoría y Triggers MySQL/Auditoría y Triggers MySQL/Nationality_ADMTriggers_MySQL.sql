-- CAMPOS DE AUDITORIA: Nationality
ALTER TABLE Nationality
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Nationality
-- Trigger Insert on Nationality
DELIMITER //

CREATE TRIGGER before_insert_Nationality
BEFORE INSERT ON Nationality
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Nationality
DELIMITER //

CREATE TRIGGER before_update_Nationality
BEFORE UPDATE ON Nationality
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;