-- CAMPOS DE AUDITORIA: Person
ALTER TABLE Person
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Person
-- Trigger Insert on Person
DELIMITER //

CREATE TRIGGER before_insert_Person
BEFORE INSERT ON Person
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Person
DELIMITER //

CREATE TRIGGER before_update_Person
BEFORE UPDATE ON Person
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;