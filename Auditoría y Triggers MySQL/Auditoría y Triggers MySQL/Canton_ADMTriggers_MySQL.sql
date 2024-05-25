-- CAMPOS DE AUDITORIA: Canton
ALTER TABLE Canton
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Canton
-- Trigger Insert on Canton
DELIMITER //

CREATE TRIGGER before_insert_Canton
BEFORE INSERT ON Canton
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Canton
DELIMITER //

CREATE TRIGGER before_update_Canton
BEFORE UPDATE ON Canton
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;