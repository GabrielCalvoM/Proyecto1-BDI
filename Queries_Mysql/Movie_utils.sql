DELIMITER //
CREATE PROCEDURE insertMovie(pIdProduct INT, pDuration INT)
BEGIN
    INSERT INTO Movie (id_product, duration_movie)
    VALUES (pIdProduct, pDuration);
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeMovie(pId INT)
BEGIN
    DECLARE vIdProduct INT;
    SELECT m.id_product INTO vIdProduct
    FROM Movie m
    LEFT JOIN Product p ON m.id_product = p.id_product
    WHERE m.id_movie = pId;
    
	DELETE FROM Movie
    WHERE id_movie = pId;
    COMMIT;
    
	CALL deleteProductPhoto(vIdProduct);
    CALL deleteArtistsForProduct(vIdProduct);
    CALL deleteProductWished(vIdProduct);
    CALL deleteProductCart(vIdProduct);
    CALL deleteProductOwned(vIdProduct);
    CALL deleteProductViewed(vIdProduct);
    CALL removeProduct(vIdProduct);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllMovies()
BEGIN
    SELECT m.id_movie, p.title, m.id_product
    FROM Movie m
    LEFT JOIN Product p ON m.id_product = p.id_product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getNmovies(pNum INT)
BEGIN
	SELECT p.title, m.id_movie, m.id_product
	FROM Movie m
	LEFT JOIN Product p ON m.id_product = p.id_product
	LIMIT pNum;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getMovieDuration(pId_product INT, OUT pDuration INT)
BEGIN
    SELECT duration_movie INTO pDuration
    FROM Movie
    WHERE id_product = pId_product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE isMovie(pId_product INT, OUT pResult INT)
BEGIN
    SELECT CASE
             WHEN COUNT(*) > 0 THEN 1
             ELSE -1
           END
    INTO pResult
    FROM Movie
    WHERE id_product = pId_product;
END //
DELIMITER ;


