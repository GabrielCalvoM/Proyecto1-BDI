DELIMITER //
CREATE FUNCTION insertSeries(pId_product INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE vId_series INT;
    INSERT INTO Series (id_product)
    VALUES (pId_product);
	SELECT LAST_INSERT_ID() INTO vId_series;
    RETURN vId_series;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeSeries(IN pId INT)
BEGIN
    DECLARE vIdProduct INT;
    SELECT s.id_product INTO vIdProduct
    FROM Series s
    LEFT JOIN Product p ON s.id_product = p.id_product
    WHERE s.id_series = pId;
    
    DELETE FROM Series
    WHERE id_series = pId;
    
	CALL deleteProductPhoto(vIdProduct);
	CALL deleteAllSeasons(pId);
    CALL deleteArtistsForProduct(vIdProduct);
    CALL deleteProductWished(vIdProduct);
    CALL deleteProductCart(vIdProduct);
    CALL deleteProductOwned(vIdProduct);
    CALL deleteProductViewed(vIdProduct);
    CALL removeProduct(vIdProduct);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllSeries()
BEGIN
    SELECT s.id_series, p.title, s.id_product
    FROM Series s
    LEFT JOIN Product p ON s.id_product = p.id_product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getNseries(IN pNum INT)
BEGIN
    SELECT p.title, s.id_series, s.id_product
    FROM (
        SELECT p.title, s.id_series, s.id_product
        FROM Series s
        LEFT JOIN Product p ON s.id_product = p.id_product
    ) AS sub
    LIMIT pNum;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getSeriesId(IN pId_product INT, OUT pId_series INT)
BEGIN
    SELECT id_series INTO pId_series
    FROM Series
    WHERE id_product = pId_product;
END //
DELIMITER ;
