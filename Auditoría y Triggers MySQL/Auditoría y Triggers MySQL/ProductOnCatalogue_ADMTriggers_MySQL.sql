-- CAMPOS DE AUDITORIA: ProductOnCatalogue
ALTER TABLE ProductOnCatalogue
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: ProductOnCatalogue
-- Trigger Insert on ProductOnCatalogue
DELIMITER //

CREATE TRIGGER before_insert_ProductOnCatalogue
BEFORE INSERT ON ProductOnCatalogue
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on ProductOnCatalogue
DELIMITER //

CREATE TRIGGER before_update_ProductOnCatalogue
BEFORE UPDATE ON ProductOnCatalogue
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;