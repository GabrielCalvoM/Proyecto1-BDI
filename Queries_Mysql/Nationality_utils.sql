DELIMITER //
CREATE PROCEDURE insertNationality(
    IN pIdPerson INT,
    IN pIdCountry INT
)
BEGIN
    INSERT INTO nationality (id_person, id_country)
    VALUES (pIdPerson, pIdCountry);
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteNationality(
    IN pIdCountry INT,
    IN pIdPerson INT
)
BEGIN
    DELETE FROM nationality
    WHERE id_person = pIdPerson
    AND id_country = pIdCountry;
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllNationalities(
    pIdPerson INT
) 
BEGIN
	SELECT id_country
	FROM nationality
	WHERE id_person = pIdPerson;
END//
DELIMITER ;
