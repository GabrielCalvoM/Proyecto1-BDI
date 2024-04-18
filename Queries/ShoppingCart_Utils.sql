CREATE OR REPLACE PACKAGE ShoppingCart_Utils IS
    -- Insert
    PROCEDURE insertShoppingCart(pId NUMBER, pId_User NUMBER);
    -- Delete
    PROCEDURE deleteShoppingCart(pId NUMBER);
END ShoppingCart_Utils;
/

CREATE OR REPLACE PACKAGE BODY ShoppingCart_Utils AS
    -- Insert
    PROCEDURE insertShoppingCart(pId NUMBER, pId_User NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ShoppingCart (id_ShoppingCart, id_User)
               VALUES (s_ShoppingCart.nextval, pId_User);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertShoppingCart;

    -- Delete
    PROCEDURE deleteShoppingCart(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ShoppingCart
        WHERE id_ShoppingCart = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteShoppingCart;

END ShoppingCart_Utils;
