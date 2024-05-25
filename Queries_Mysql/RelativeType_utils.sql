DELIMITER //
CREATE PROCEDURE insertRelativeType(
    IN pName VARCHAR(255)
)
BEGIN
    INSERT INTO proy1.RelativeType (name_RelativeType)
    VALUES (pName);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteRelativeType(
    IN pId INT
)
BEGIN
    DELETE FROM proy1.RelativeType
    WHERE id_RelativeType = pId;
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE FUNCTION getRelativeTypeName(
    pId INT
) 
RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vName VARCHAR(255);
    SELECT name_RelativeType INTO vName
    FROM RelativeType
    WHERE id_RelativeType = pId;
    RETURN vName;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getRelativeTypes()
BEGIN 
    SELECT id_relativeType, name_relativeType
    FROM RelativeType;
END//
DELIMITER ;
