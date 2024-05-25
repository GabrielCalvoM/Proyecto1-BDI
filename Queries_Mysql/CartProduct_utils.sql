DELIMITER //
CREATE PROCEDURE insertCartProduct(
    IN pId_Product INT, 
    IN pId_Cart INT
)
BEGIN
    INSERT INTO CartProduct (id_product, id_shoppingCart)
    VALUES (pId_Product, pId_Cart);
END //
DELIMITER ;

-- Delete a product from a shopping cart
DELIMITER //
CREATE PROCEDURE deleteCartProduct(
    IN pId_product INT, 
    IN pId_Cart INT
)
BEGIN
    DELETE FROM CartProduct
    WHERE id_product = pId_product AND id_shoppingCart = pId_Cart;
END //
DELIMITER ;

-- Delete a product from all shopping carts
DELIMITER //
CREATE PROCEDURE deleteProductCart(
    IN pId_product INT
)
BEGIN
    DELETE FROM CartProduct
    WHERE id_product = pId_product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProductsInCart(
    IN pId_Cart INT
)
BEGIN
    SELECT id_product
    FROM CartProduct
    WHERE id_shoppingCart = pId_Cart;
END //
DELIMITER ;
