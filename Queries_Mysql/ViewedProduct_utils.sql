DELIMITER //
CREATE PROCEDURE insertViewedProduct(pId_User INT, pId_Product INT)
BEGIN
    CALL deleteViewedProduct(pId_User, pId_Product);
    INSERT INTO ViewedProduct (id_product, id_user)
    VALUES (pId_Product, pId_User);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteViewedProduct(pId_User INT, pId_Product INT)
BEGIN
    DELETE FROM ViewedProduct
    WHERE id_product = pId_Product AND
          id_user = pId_User;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteProductViewed(pId_Product INT)
BEGIN
    DELETE FROM ViewedProduct
    WHERE id_product = pId_Product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getViewedProducts(pId_User INT)
BEGIN
    SELECT pr.id_product
    FROM ViewedProduct vp
    JOIN Product pr
    ON pr.id_product = vp.id_product
    WHERE vp.id_user = pId_User
    ORDER BY vp.id_viewedProduct DESC;
END //
DELIMITER ;