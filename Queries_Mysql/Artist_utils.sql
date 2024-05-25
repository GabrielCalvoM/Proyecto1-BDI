DELIMITER //
CREATE PROCEDURE insertArtist(IN pId INT, IN pId_type INT, IN pBiography VARCHAR(3000), IN pTrivia VARCHAR(1000))
BEGIN
    INSERT INTO Artist (id_artist, id_artisttype, biography_artist, trivia_data)
    VALUES (pId, pId_type, pBiography, pTrivia);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteArtist(IN pId INT)
BEGIN
    CALL deleteArtistPhoto(pId);
    CALL deleteArtistRelatives(pId);
    
    DELETE FROM Artist
    WHERE id_artist = pId;
    
    DELETE FROM Person
    WHERE id_person = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateArtist(IN pId INT, IN pId_type INT, IN pBiography VARCHAR(255), IN pTrivia VARCHAR(255))
BEGIN
    UPDATE Artist
    SET id_artistType = pId_type, biography_artist = pBiography, trivia_data = pTrivia
    WHERE id_artist = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getArtistsOfType(IN pId_type INT)
BEGIN
    SELECT a.id_artist, p.first_name, p.last_name
    FROM Artist a
    JOIN Person p ON a.id_artist = p.id_person
    WHERE id_artistType = pId_type;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getTypeOfArtist(pId INT) RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vIdType INT;
    
    SELECT id_artisttype INTO vIdType
    FROM Artist
    WHERE id_artist = pId;
    
    RETURN vIdType;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE getArtist(IN pId INT, OUT pFirst_name VARCHAR(255), OUT pLast_name VARCHAR(255), 
    OUT pArtistType VARCHAR(255), OUT pArtistTypeId INT, OUT pBiography VARCHAR(3000), OUT pTrivia VARCHAR(1000),
    OUT pDate VARCHAR(255), OUT pHeight INT)
BEGIN
    SELECT p.first_name, p.last_name, t.name_type, a.id_artisttype, a.biography_artist, a.trivia_data, 
        DATE_FORMAT(p.birth_date, '%d-%m-%Y'), p.height_artist
    INTO pFirst_name, pLast_name, pArtistType, pArtistTypeId, pBiography, pTrivia, pDate, pHeight
    FROM Artist a
    JOIN Person p ON a.id_artist = p.id_person
    JOIN ArtistType t ON a.id_artisttype = t.id_artisttype
    WHERE a.id_artist = pId;
END //
DELIMITER ;
