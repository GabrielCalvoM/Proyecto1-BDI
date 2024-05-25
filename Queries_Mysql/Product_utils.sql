DELIMITER //
CREATE FUNCTION insertProduct(pTitle VARCHAR(255), pYear INT,
                pSynopsis VARCHAR(255), pTrailer VARCHAR(255), pPrice DECIMAL(10,2))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE vIdProduct INT;
    INSERT INTO Product (title, premiere_year,
                             synopsis, trailer, price)
            VALUES (pTitle, pYear, pSynopsis,
                    pTrailer, pPrice);
	SELECT LAST_INSERT_ID() INTO vIdProduct;
    RETURN vIdProduct;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeProduct(pId INT)
BEGIN
    DELETE FROM ProductCategory
    WHERE id_product = pId;
    DELETE FROM WishedProduct
    WHERE id_product = pId;
    DELETE FROM CartProduct
    WHERE id_Product = pId;
    DELETE FROM ViewedProduct
    WHERE id_product = pId;
    DELETE FROM OwnedProduct
    WHERE id_product = pId;
    DELETE FROM Product
    WHERE id_product = pId;
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProduct(pId INT, OUT pTitle VARCHAR(255), OUT pPremiere INT, 
        OUT pSynopsis VARCHAR(255), OUT pTrailer VARCHAR(255), OUT pPrice DECIMAL(10,2))
BEGIN 
    SELECT title, premiere_year, synopsis, trailer, price
    INTO pTitle, pPremiere, pSynopsis, pTrailer, pPrice
    FROM Product
    WHERE id_product = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE searchProducts(IN pSearch VARCHAR(255))
BEGIN
    SELECT id_product
    FROM Product
    WHERE title LIKE CONCAT('%', pSearch, '%');
END //
DELIMITER ;
