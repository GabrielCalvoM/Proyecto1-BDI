-- CAMPOS DE AUDITORIA: Product
ALTER TABLE Product
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Product
-- Trigger Insert on Product
DELIMITER //

CREATE TRIGGER before_insert_Product
BEFORE INSERT ON Product
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Product
DELIMITER //

CREATE TRIGGER before_update_Product
BEFORE UPDATE ON Product
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;