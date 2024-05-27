DELIMITER //
CREATE PROCEDURE insertArtistPhoto(
    IN pIdPhoto INT, 
    IN pIdArtist INT
)
BEGIN
    INSERT INTO proy1.artistPhoto (id_photo, id_artist)
    VALUES (pIdPhoto, pIdArtist);
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteArtistPhoto(
    IN pIdArtist INT
)
BEGIN
    DELETE FROM proy1.artistPhoto
    WHERE id_artist = pIdArtist;

    DELETE FROM photo
    WHERE id_photo NOT IN (SELECT id_photo FROM ArtistPhoto);
    COMMIT;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getArtistPhoto(
    IN pIdArtist INT
)
BEGIN
    SELECT ph.picture
    FROM artistPhoto aph
    LEFT JOIN photo ph ON aph.id_photo = ph.id_photo
    WHERE aph.id_artist = pIdArtist;
END//
DELIMITER ;
