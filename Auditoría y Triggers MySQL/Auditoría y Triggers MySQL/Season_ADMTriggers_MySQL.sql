-- CAMPOS DE AUDITORIA: Season
ALTER TABLE Season
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Season
-- Trigger Insert on Season
DELIMITER //

CREATE TRIGGER before_insert_Season
BEFORE INSERT ON Season
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Season
DELIMITER //

CREATE TRIGGER before_update_Season
BEFORE UPDATE ON Season
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;