-- CAMPOS DE AUDITORIA: OwnedProduct
ALTER TABLE OwnedProduct
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: OwnedProduct
-- Trigger Insert on OwnedProduct
DELIMITER //

CREATE TRIGGER before_insert_OwnedProduct
BEFORE INSERT ON OwnedProduct
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on OwnedProduct
DELIMITER //

CREATE TRIGGER before_update_OwnedProduct
BEFORE UPDATE ON OwnedProduct
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;