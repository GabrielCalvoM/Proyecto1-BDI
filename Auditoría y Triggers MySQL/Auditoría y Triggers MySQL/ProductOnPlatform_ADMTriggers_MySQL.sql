-- CAMPOS DE AUDITORIA: ProductOnPlatform
ALTER TABLE ProductOnPlatform
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ProductOnPlatform
-- Trigger Insert on ProductOnPlatform
DELIMITER //

CREATE TRIGGER before_insert_ProductOnPlatform
BEFORE INSERT ON ProductOnPlatform
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ProductOnPlatform
DELIMITER //

CREATE TRIGGER before_update_ProductOnPlatform
BEFORE UPDATE ON ProductOnPlatform
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;