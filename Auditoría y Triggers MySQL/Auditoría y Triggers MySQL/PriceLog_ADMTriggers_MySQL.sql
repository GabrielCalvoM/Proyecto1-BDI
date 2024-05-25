-- CAMPOS DE AUDITORIA: PriceLog
ALTER TABLE PriceLog
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: PriceLog
-- Trigger Insert on PriceLog
DELIMITER //

CREATE TRIGGER before_insert_PriceLog
BEFORE INSERT ON PriceLog
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on PriceLog
DELIMITER //

CREATE TRIGGER before_update_PriceLog
BEFORE UPDATE ON PriceLog
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;