-- CAMPOS DE AUDITORIA: sysUser
ALTER TABLE sysUser
    ADD (
        created_by      VARCHAR(25),
        creation_date   DATE,   
        updated_by      VARCHAR(25),
        update_date     DATE
    );

-- TRIGGERS: sysUser
-- Trigger Insert on sysUser
DELIMITER //

CREATE TRIGGER before_insert_sysUser
BEFORE INSERT ON sysUser
FOR EACH ROW
BEGIN
    SET NEW.created_by = USER();
    SET NEW.creation_date = CURDATE();
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;

-- Trigger Update on sysUser
DELIMITER //

CREATE TRIGGER before_update_sysUser
BEFORE UPDATE ON sysUser
FOR EACH ROW
BEGIN
    SET NEW.updated_by = USER();
    SET NEW.update_date = CURDATE();
END //

DELIMITER ;