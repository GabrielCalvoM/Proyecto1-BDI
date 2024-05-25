DELIMITER //
CREATE PROCEDURE insertShoppingCart(pId_User INT)
BEGIN
    INSERT INTO ShoppingCart (id_User)
    VALUES (pId_User);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteShoppingCart(pId INT)
BEGIN
    DELETE FROM ShoppingCart
    WHERE id_ShoppingCart = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getCartId(pId_User INT) 
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE vId_cart INT;
    SELECT id_shoppingCart INTO vId_cart
    FROM ShoppingCart
    WHERE id_user = pId_User;
    RETURN vId_cart;
END //
DELIMITER ;
