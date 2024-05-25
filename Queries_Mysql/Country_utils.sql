DELIMITER //
CREATE PROCEDURE getCountries()
READS SQL DATA
BEGIN
    SELECT id_country, name FROM Country;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE insertCountry(IN pName VARCHAR(255))
BEGIN
    INSERT INTO Country(name)
    VALUES(pName);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeCountry(IN pId INT)
BEGIN
    DELETE FROM Country
    WHERE id_country = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getCountryName(pId INT) RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vName VARCHAR(255);
    SELECT name INTO vName
    FROM Country
    WHERE id_country = pId;
    RETURN vName;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateCountry(IN pId INT, IN pName VARCHAR(255))
BEGIN
    UPDATE Country
    SET name = pName
    WHERE id_country = pId;
END //
DELIMITER ;

