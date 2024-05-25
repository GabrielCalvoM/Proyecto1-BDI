-- CAMPOS DE AUDITORIA: ShoppingCart
ALTER TABLE ShoppingCart
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ShoppingCart
-- Trigger Insert on ShoppingCart
DELIMITER //

CREATE TRIGGER before_insert_ShoppingCart
BEFORE INSERT ON ShoppingCart
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ShoppingCart
DELIMITER //

CREATE TRIGGER before_update_ShoppingCart
BEFORE UPDATE ON ShoppingCart
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;