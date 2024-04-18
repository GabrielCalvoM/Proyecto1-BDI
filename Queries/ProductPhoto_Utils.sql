CREATE OR REPLACE PACKAGE ProductPhoto_Utils IS
    -- Insert
    PROCEDURE insertProductPhoto(pId NUMBER, pId_Product NUMBER, pId_Photo NUMBER);
    -- Delete
    PROCEDURE deleteProductPhoto(pId NUMBER);
END ProductPhoto_Utils;
/

CREATE OR REPLACE PACKAGE BODY ProductPhoto_Utils AS
    -- Insert
    PROCEDURE insertProductPhoto(pId NUMBER, pId_Product NUMBER, pId_Photo NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ProductPhoto (id_ProductPhoto, id_product, id_photo)
               VALUES (s_ProductPhoto.nextval, pId_Product, pId_Photo);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertProductPhoto;

    -- Delete
    PROCEDURE deleteProductPhoto(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ProductPhoto
        WHERE id_ProductPhoto = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteProductPhoto;

END ProductPhoto_Utils;
