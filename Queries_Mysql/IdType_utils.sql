DELIMITER //
CREATE PROCEDURE insertType(pType VARCHAR(255))
BEGIN
    INSERT INTO identificationType (name)
    VALUES (pType);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteType(pId INT)
BEGIN
    DELETE FROM identificationType
    WHERE id_type = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE setType(pId INT, pType VARCHAR(255))
BEGIN
    UPDATE identificationType
    SET name = pType
    WHERE id_type = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getType(pId INT) 
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE vName VARCHAR(255);
    SELECT name INTO vName
    FROM identificationType
    WHERE id_type = pId;
    RETURN vName;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getTypes()
BEGIN
    SELECT id_type, name
    FROM identificationType;
END //
DELIMITER ;
