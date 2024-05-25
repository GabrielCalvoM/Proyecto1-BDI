DELIMITER //
CREATE PROCEDURE insertWishlist(pId_User INT)
BEGIN
    INSERT INTO Wishlist (id_User)
    VALUES (pId_User);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteWishlist(pId INT)
BEGIN
    DELETE FROM Wishlist
    WHERE id_Wishlist = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getWishlistId(pId_User INT) 
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE vId_wishlist INT;
    SELECT id_wishlist INTO vId_wishlist
    FROM Wishlist
    WHERE id_user = pId_User;
    RETURN vId_wishlist;
END //
DELIMITER ;
