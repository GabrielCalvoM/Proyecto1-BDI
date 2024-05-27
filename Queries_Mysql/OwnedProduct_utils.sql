DELIMITER //
CREATE PROCEDURE insertOwnedProduct(
    IN pProduct INT, 
    IN pUser INT,
    IN pPurchase VARCHAR(10)
)
BEGIN
    INSERT INTO OwnedProduct (id_product, id_user, date_bought)
    VALUES (pProduct, pUser, STR_TO_DATE(pPurchase, '%d-%m-%Y'));
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteOwnedProduct(
    IN pId INT
)
BEGIN
    DELETE FROM OwnedProduct
    WHERE id_ownedProduct = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteProductOwned(
    IN pId_product INT
)
BEGIN
    DELETE FROM OwnedProduct
    WHERE id_product = pId_product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getOwnedProducts(
    IN pId_User INT
)
BEGIN
    SELECT id_product, date_bought
    FROM OwnedProduct
    WHERE id_user = pId_User
    ORDER BY date_bought DESC;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProductsFilter(
    IN pId_User INT,
    IN pMonths INT
)
BEGIN
    SELECT id_product, date_bought
    FROM OwnedProduct
    WHERE id_user = pId_User 
	AND date_bought >= DATE_SUB(CURDATE(), INTERVAL pMonths MONTH)
    ORDER BY date_bought DESC;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getTopOwnedProducts(
    IN pTopN INT
)
BEGIN
		SELECT id_product, num_owners FROM
		(SELECT id_product, COUNT(id_product) AS num_owners
		FROM OwnedProduct
		GROUP BY id_product
		ORDER BY num_owners DESC) AS top_products
        LIMIT pTopN;
END //
DELIMITER ;

DROP PROCEDURE getTopOwnedProducts;