create or replace PACKAGE ShoppingCart_Utils IS
    -- Insert
    PROCEDURE insertShoppingCart(pId_User NUMBER);
    -- Delete
    PROCEDURE deleteShoppingCart(pId NUMBER);
    -- Get
    FUNCTION getCartId(pId_User NUMBER) RETURN NUMBER;
END ShoppingCart_Utils;


create or replace PACKAGE BODY ShoppingCart_Utils AS
    -- Insert
    PROCEDURE insertShoppingCart(pId_User NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ShoppingCart(id_ShoppingCart, id_User)
               VALUES (s_shoppingCart.nextval, pId_User);
        COMMIT;
    END insertShoppingCart;

    -- Delete
    PROCEDURE deleteShoppingCart(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ShoppingCart
        WHERE id_ShoppingCart = pId;
        COMMIT;
    END deleteShoppingCart;

    FUNCTION getCartId(pId_User NUMBER) 
    RETURN NUMBER
    IS
        vId_cart NUMBER;
    BEGIN
        SELECT id_shoppingCart INTO vId_cart
        FROM ShoppingCart
        WHERE id_user = pId_User;
        RETURN vId_cart;
    END getCartId;
    
END ShoppingCart_Utils;
