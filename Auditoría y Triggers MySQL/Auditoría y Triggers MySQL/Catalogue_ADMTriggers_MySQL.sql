-- CAMPOS DE AUDITORIA: Catalogue
ALTER TABLE Catalogue
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Catalogue
-- Trigger Insert on Catalogue
DELIMITER //

CREATE TRIGGER before_insert_Catalogue
BEFORE INSERT ON Catalogue
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Catalogue
DELIMITER //

CREATE TRIGGER before_update_Catalogue
BEFORE UPDATE ON Catalogue
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;