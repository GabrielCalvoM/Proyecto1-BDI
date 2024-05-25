-- CAMPOS DE AUDITORIA: RelativeType
ALTER TABLE RelativeType
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: RelativeType
-- Trigger Insert on RelativeType
DELIMITER //

CREATE TRIGGER before_insert_RelativeType
BEFORE INSERT ON RelativeType
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on RelativeType
DELIMITER //

CREATE TRIGGER before_update_RelativeType
BEFORE UPDATE ON RelativeType
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;