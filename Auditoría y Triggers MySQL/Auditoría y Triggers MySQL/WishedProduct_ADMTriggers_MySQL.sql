-- CAMPOS DE AUDITORIA: WishedProduct
ALTER TABLE WishedProduct
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: WishedProduct
-- Trigger Insert on WishedProduct
DELIMITER //

CREATE TRIGGER before_insert_WishedProduct
BEFORE INSERT ON WishedProduct
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on WishedProduct
DELIMITER //

CREATE TRIGGER before_update_WishedProduct
BEFORE UPDATE ON WishedProduct
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;