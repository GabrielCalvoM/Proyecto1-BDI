-- CAMPOS DE AUDITORIA: StreamPlatform
ALTER TABLE StreamPlatform
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: StreamPlatform
-- Trigger Insert on StreamPlatform
DELIMITER //

CREATE TRIGGER before_insert_StreamPlatform
BEFORE INSERT ON StreamPlatform
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on StreamPlatform
DELIMITER //

CREATE TRIGGER before_update_StreamPlatform
BEFORE UPDATE ON StreamPlatform
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;