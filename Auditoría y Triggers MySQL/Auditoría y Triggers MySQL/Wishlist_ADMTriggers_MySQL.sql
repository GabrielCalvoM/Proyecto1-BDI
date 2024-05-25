-- CAMPOS DE AUDITORIA: Wishlist
ALTER TABLE Wishlist
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Wishlist
-- Trigger Insert on Wishlist
DELIMITER //

CREATE TRIGGER before_insert_Wishlist
BEFORE INSERT ON Wishlist
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Wishlist
DELIMITER //

CREATE TRIGGER before_update_Wishlist
BEFORE UPDATE ON Wishlist
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;