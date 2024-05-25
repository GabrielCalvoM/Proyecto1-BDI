-- CAMPOS DE AUDITORIA: Movie
ALTER TABLE Movie
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: Movie
-- Trigger Insert on Movie
DELIMITER //

CREATE TRIGGER before_insert_Movie
BEFORE INSERT ON Movie
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on Movie
DELIMITER //

CREATE TRIGGER before_update_Movie
BEFORE UPDATE ON Movie
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;