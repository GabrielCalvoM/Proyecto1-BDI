-- CAMPOS DE AUDITORIA: CartProduct
ALTER TABLE CartProduct
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: CartProduct
-- Trigger Insert on CartProduct
DELIMITER //

CREATE TRIGGER before_insert_CartProduct
BEFORE INSERT ON CartProduct
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on CartProduct
DELIMITER //

CREATE TRIGGER before_update_CartProduct
BEFORE UPDATE ON CartProduct
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;