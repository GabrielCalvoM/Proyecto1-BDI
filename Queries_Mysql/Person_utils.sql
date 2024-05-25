DELIMITER //
CREATE FUNCTION insertPerson(pFirstName VARCHAR(255), pLastName VARCHAR(255),
                              pBirth VARCHAR(10), pHeight INT,
                              pGender INT)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vIdPerson INT;
    INSERT INTO person (first_name, last_name, birth_date,
                        height_artist, id_gender)
    VALUES (pFirstName, pLastName,
            STR_TO_DATE(pBirth, '%d-%m-%Y'), pHeight, pGender);
	SELECT LAST_INSERT_ID() INTO vIdPerson;
    RETURN vIdPerson;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deletePerson(IN pId INT)
BEGIN
    DELETE FROM person WHERE id_person = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updatePerson(
    IN pId INT,
    IN pFirstName VARCHAR(255),
    IN pLastName VARCHAR(255),
    IN pBirth DATE,
    IN pHeight INT,
    IN pGender INT
)
BEGIN
    UPDATE person
    SET first_name = pFirstName,
        last_name = pLastName,
        birth_date = pBirth,
        height_artist = pHeight,
        id_gender = pGender
    WHERE id_person = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getPerson(
    IN pId INT,
    OUT pFirst_name VARCHAR(255),
    OUT pLast_name VARCHAR(255),
    OUT pDate DATE,
    OUT pGender INT
)
BEGIN
    SELECT first_name, last_name, birth_date, id_gender
    INTO pFirst_name, pLast_name, pDate, pGender
    FROM person
    WHERE id_person = pId;
END //
DELIMITER ;