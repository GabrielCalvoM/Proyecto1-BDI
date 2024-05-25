-- CAMPOS DE AUDITORIA: ProductPhoto
ALTER TABLE ProductPhoto
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ProductPhoto
-- Trigger Insert on ProductPhoto
DELIMITER //

CREATE TRIGGER before_insert_ProductPhoto
BEFORE INSERT ON ProductPhoto
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ProductPhoto
DELIMITER //

CREATE TRIGGER before_update_ProductPhoto
BEFORE UPDATE ON ProductPhoto
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;