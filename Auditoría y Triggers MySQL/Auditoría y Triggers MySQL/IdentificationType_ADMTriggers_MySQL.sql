-- CAMPOS DE AUDITORIA: IdentificationType
ALTER TABLE IdentificationType
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: IdentificationType
-- Trigger Insert on IdentificationType
DELIMITER //

CREATE TRIGGER before_insert_IdentificationType
BEFORE INSERT ON IdentificationType
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on IdentificationType
DELIMITER //

CREATE TRIGGER before_update_IdentificationType
BEFORE UPDATE ON IdentificationType
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;