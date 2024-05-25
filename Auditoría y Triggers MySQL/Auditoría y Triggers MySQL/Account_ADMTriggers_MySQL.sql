-- CAMPOS DE AUDITORIA: userAccount
ALTER TABLE userAccount
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: userAccount
-- Trigger Insert on userAccount
DELIMITER //

CREATE TRIGGER before_insert_userAccount
BEFORE INSERT ON userAccount
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on userAccount
DELIMITER //

CREATE TRIGGER before_update_userAccount
BEFORE UPDATE ON userAccount
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;


