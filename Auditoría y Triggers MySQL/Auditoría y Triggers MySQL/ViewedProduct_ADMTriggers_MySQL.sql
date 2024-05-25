-- CAMPOS DE AUDITORIA: ViewedProduct
ALTER TABLE ViewedProduct
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ViewedProduct
-- Trigger Insert on ViewedProduct
DELIMITER //

CREATE TRIGGER before_insert_ViewedProduct
BEFORE INSERT ON ViewedProduct
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ViewedProduct
DELIMITER //

CREATE TRIGGER before_update_ViewedProduct
BEFORE UPDATE ON ViewedProduct
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;