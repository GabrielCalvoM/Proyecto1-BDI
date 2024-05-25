DELIMITER //
CREATE PROCEDURE insertGender(pName VARCHAR(255))
BEGIN
    INSERT INTO gender (name)
    VALUES (pName);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteGender(pId INT)
BEGIN
    DELETE FROM gender
    WHERE id_gender = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE setGender(pId INT, pName VARCHAR(255))
BEGIN
    UPDATE gender
    SET name = pName
    WHERE id_gender = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getGender(pId INT) RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vName VARCHAR(255);
    SELECT name INTO vName
    FROM gender
    WHERE id_gender = pId;
    RETURN vName;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getGenders()
READS SQL DATA
BEGIN
    SELECT id_gender, name FROM gender;
END //
DELIMITER ;

CALL insertGender('Hombre');
CALL insertGender('Mujer');
CALL insertGender('Otro');

