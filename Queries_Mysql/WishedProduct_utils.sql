DELIMITER //
CREATE PROCEDURE insertWishedProduct(
    IN pId_Product INT, 
    IN pId_Wishlist INT
)
BEGIN
    INSERT INTO WishedProduct (id_product, id_wishlist)
    VALUES (pId_Product, pId_Wishlist);
END //
DELIMITER ;

-- Deletes a product from a wishlist
DELIMITER //
CREATE PROCEDURE deleteWishedProduct(
    IN pId_product INT, 
    IN pId_Wishlist INT
)
BEGIN
    DELETE FROM WishedProduct
    WHERE id_product = pId_product AND id_wishlist = pId_Wishlist;
END //
DELIMITER ;

-- Deletes a product from all wishlists
DELIMITER //
CREATE PROCEDURE deleteProductWished(
    IN pId_product INT
)
BEGIN
    DELETE FROM WishedProduct
    WHERE id_product = pId_product;
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProductsInWishlist(
    IN pId_Wishlist INT
)
BEGIN
    SELECT id_product
    FROM WishedProduct
    WHERE id_wishlist = pId_Wishlist;
END //
DELIMITER ;
