create or replace PACKAGE CartProduct_Utils IS
    -- Insert
    PROCEDURE insertCartProduct(pId_Product NUMBER, pId_Cart NUMBER);
    -- Delete
    PROCEDURE deleteCartProduct(pId_product NUMBER, pId_Cart NUMBER);
    PROCEDURE deleteProduct(pId_product NUMBER);

    PROCEDURE getProductsInCart(pId_Cart NUMBER, productsCursors OUT SYS_REFCURSOR);
END CartProduct_Utils;
/

create or replace PACKAGE BODY CartProduct_Utils AS
    -- Insert
    PROCEDURE insertCartProduct(pId_Product NUMBER, pId_Cart NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.CartProduct (id_CartProduct, id_product, id_shoppingCart)
               VALUES (s_cartProduct.nextval, pId_Product, pId_Cart);
        COMMIT;
    END insertCartProduct;

    -- Delete
    PROCEDURE deleteCartProduct(pId_product NUMBER, pId_Cart NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.CartProduct
        WHERE id_product = pId_product AND
        id_shoppingCart = pId_Cart;
        COMMIT;    
    END deleteCartProduct;
    
    PROCEDURE deleteProduct(pId_product NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.CartProduct
        WHERE id_product = pId_product;
        COMMIT;
    END deleteProduct;

    PROCEDURE getProductsInCart(pId_Cart NUMBER, productsCursors OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursors
        FOR
        SELECT id_product
        FROM CartProduct
        WHERE id_shoppingCart = pId_Cart;
    END getProductsInCart;

END CartProduct_Utils;
