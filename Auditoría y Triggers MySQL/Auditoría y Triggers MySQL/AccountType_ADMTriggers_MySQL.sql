-- CAMPOS DE AUDITORIA: accountType
ALTER TABLE accountType
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: accountType
-- Trigger Insert on accountType
DELIMITER //

CREATE TRIGGER before_insert_accountType
BEFORE INSERT ON accountType
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on accountType
DELIMITER //

CREATE TRIGGER before_update_accountType
BEFORE UPDATE ON accountType
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;