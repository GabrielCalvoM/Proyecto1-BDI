DELIMITER //
CREATE PROCEDURE insertProductArtist(pProduct INT, pArtist INT)
BEGIN
    INSERT INTO productArtist (id_product, id_artist)
    VALUES (pProduct, pArtist);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteArtistsForProduct(pIdProduct INT)
BEGIN
    DELETE FROM ProductArtist
    WHERE id_product = pIdProduct;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getArtistsInProduct(pIdProduct INT)
BEGIN
    SELECT id_artist
    FROM ProductArtist
    WHERE id_product = pIdProduct;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getArtistProducts(pArtist INT)
BEGIN
	SELECT id_product
	FROM productArtist
	WHERE id_artist = pArtist;
END //
DELIMITER ;