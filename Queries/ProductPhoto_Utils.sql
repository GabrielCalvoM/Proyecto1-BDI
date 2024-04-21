CREATE OR REPLACE PACKAGE ProductPhoto_Utils IS
    -- Insert
    PROCEDURE insertProductPhoto(pId_Photo NUMBER, pId_Product NUMBER);
    -- Delete
    PROCEDURE deleteProductPhoto(pIdProduct NUMBER);
END ProductPhoto_Utils;
/

CREATE OR REPLACE PACKAGE BODY ProductPhoto_Utils AS
    -- Insert
    PROCEDURE insertProductPhoto(pId_Photo NUMBER, pId_Product NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ProductPhoto
               VALUES (pId_Photo, pId_product);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertProductPhoto;

    -- Delete
    PROCEDURE deleteProductPhoto(pIdProduct NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ProductPhoto
        WHERE id_product = pIdProduct;
        
        DELETE FROM Photo
        WHERE id_photo NOT IN
        (SELECT id_productPhoto FROM ProductPhoto);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteProductPhoto;

END ProductPhoto_Utils;
