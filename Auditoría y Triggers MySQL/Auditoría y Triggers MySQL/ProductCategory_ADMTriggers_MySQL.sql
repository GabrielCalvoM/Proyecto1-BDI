-- CAMPOS DE AUDITORIA: ProductCategory
ALTER TABLE ProductCategory
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ProductCategory
-- Trigger Insert on ProductCategory
DELIMITER //

CREATE TRIGGER before_insert_ProductCategory
BEFORE INSERT ON ProductCategory
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ProductCategory
DELIMITER //

CREATE TRIGGER before_update_ProductCategory
BEFORE UPDATE ON ProductCategory
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;