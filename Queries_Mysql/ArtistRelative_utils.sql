DELIMITER //
CREATE PROCEDURE insertArtistRelative(
    IN pId_Artist INT,
    IN pId_Relative INT,
    IN pId_RelationType INT
)
BEGIN
    INSERT INTO proy1.ArtistRelative (id_Artist, id_Relative, id_RelationType)
    VALUES (pId_Artist, pId_Relative, pId_RelationType);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteArtistRelative(
    IN pId INT
)
BEGIN
    DELETE FROM proy1.ArtistRelative
    WHERE id_ArtistRelative = pId;
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteArtistRelatives(
    IN pId_Artist INT
)
BEGIN
    DELETE FROM proy1.ArtistRelative
    WHERE id_artist = pId_Artist;
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateArtistRelativeRelation (
    IN pId INT,
    IN pId_Relation INT
)
BEGIN
    UPDATE proy1.ArtistRelative
    SET id_relationType = pId_Relation
    WHERE id_ArtistRelative = pId;
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE FUNCTION getArtistRelativeRelation (
    pId INT
) 
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vId_Relation INT;
    SELECT id_RelationType INTO vId_Relation
    FROM ArtistRelative
    WHERE id_ArtistRelative = pId;
    RETURN vId_Relation;
END//
DELIMITER ;

DELIMITER //

CREATE PROCEDURE getArtistRelatives(
    IN pId_Artist INT
)
BEGIN
    SELECT r.id_artistrelative, r.id_relative, p.first_name, p.last_name, r.id_relationtype
    FROM ArtistRelative r
    JOIN Person p
    ON r.id_relative = p.id_person
    WHERE id_artist = pId_Artist;
END//
DELIMITER ;
