-- CAMPOS DE AUDITORIA: Review
ALTER TABLE Review
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Review
-- Trigger Insert on Review
DELIMITER //

CREATE TRIGGER before_insert_Review
BEFORE INSERT ON Review
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Review
DELIMITER //

CREATE TRIGGER before_update_Review
BEFORE UPDATE ON Review
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;