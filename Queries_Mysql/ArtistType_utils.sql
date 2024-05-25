DELIMITER //
CREATE PROCEDURE insertArtistType(IN pname_Type VARCHAR(255))
BEGIN
    INSERT INTO ArtistType (name_Type)
    VALUES (pname_Type);
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getArtistType(pId INT) RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vname_Type VARCHAR(255);
    
    SELECT name_Type INTO vname_Type
    FROM ArtistType
    WHERE id_ArtistType = pId;
    
    RETURN vname_Type;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getArtistTypes()
READS SQL DATA
BEGIN 
    SELECT id_ArtistType, name_Type
    FROM ArtistType;
END //
DELIMITER ;
