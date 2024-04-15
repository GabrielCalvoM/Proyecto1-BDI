CREATE OR REPLACE PACKAGE WishedProduct_Utils IS
    -- Insert
    PROCEDURE insertWishedProduct(pId NUMBER, pId_Product NUMBER, pId_Wishlist NUMBER);
    -- Delete
    PROCEDURE deleteWishedProduct(pId NUMBER);
END WishedProduct_Utils;
/

CREATE OR REPLACE PACKAGE BODY WishedProduct_Utils AS
    -- Insert
    PROCEDURE insertWishedProduct(pId NUMBER, pId_Product NUMBER, pId_Wishlist NUMBER)
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
    PROCEDURE deleteWishedProduct(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.WishedProduct
        WHERE id_WishedProduct = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteWishedProduct;

END WishedProduct_Utils;
