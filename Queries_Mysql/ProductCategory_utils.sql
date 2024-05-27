DELIMITER //
CREATE PROCEDURE insertProductCategory(IN pProduct INT, IN pCategory INT)
BEGIN
    INSERT INTO productCategory (id_product, id_category)
    VALUES (pProduct, pCategory);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteProductCategory(IN pId_Product INT)
BEGIN
    DELETE FROM ProductCategory
    WHERE id_product = pId_Product;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getProductCategory(pId_Product INT) RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vCategory VARCHAR(255);
    SELECT c.name INTO vCategory
    FROM ProductCategory pc
    JOIN Category c ON pc.id_category = c.id_category
    WHERE pc.id_product = pId_Product;
    
    RETURN vCategory;
END //
DELIMITER ;