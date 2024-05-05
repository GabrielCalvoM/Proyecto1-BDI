create or replace PACKAGE WishedProduct_Utils IS
    -- Insert
    PROCEDURE insertWishedProduct(pId_Product NUMBER, pId_Wishlist NUMBER);
    -- Delete
    PROCEDURE deleteWishedProduct(pId_product NUMBER, pId_Wishlist NUMBER);

    PROCEDURE getProductsInWishlist(pId_Wishlist NUMBER, productsCursors OUT SYS_REFCURSOR);
END WishedProduct_Utils;
/

create or replace PACKAGE BODY WishedProduct_Utils AS
    -- Insert
    PROCEDURE insertWishedProduct(pId_Product NUMBER, pId_Wishlist NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.WishedProduct (id_WishedProduct, id_product, Id_Wishlist)
               VALUES (s_WishedProduct.nextval, pId_Product, pId_Wishlist);
        COMMIT;

    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');

    END insertWishedProduct;

    -- Delete
    PROCEDURE deleteWishedProduct(pId_product NUMBER, pId_Wishlist NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.WishedProduct
        WHERE id_product = pId_product AND
        id_wishlist = pId_Wishlist;
        COMMIT;    
    END deleteWishedProduct;

    PROCEDURE getProductsInWishlist(pId_Wishlist NUMBER, productsCursors OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursors
        FOR
        SELECT id_product
        FROM WishedProduct
        WHERE id_wishlist = pId_Wishlist;
    END getProductsInWishlist;

END WishedProduct_Utils;
