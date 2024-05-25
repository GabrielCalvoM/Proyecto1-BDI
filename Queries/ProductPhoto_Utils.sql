CREATE OR REPLACE PACKAGE ProductPhoto_Utils IS
    -- Insert
    PROCEDURE insertProductPhoto(pId_Photo NUMBER, pId_Product NUMBER);
    -- Delete
    PROCEDURE deleteProductPhoto(pIdProduct NUMBER);
    -- Get
    FUNCTION getProductMainImg(pIdProduct NUMBER) RETURN VARCHAR2;
    PROCEDURE getProductPhotos(pIdProduct NUMBER, photoCursor OUT SYS_REFCURSOR);
END ProductPhoto_Utils;


CREATE OR REPLACE PACKAGE BODY ProductPhoto_Utils AS
    -- Insert
    PROCEDURE insertProductPhoto(pId_Photo NUMBER, pId_Product NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ProductPhoto (id_productphoto, id_product)
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
    
    FUNCTION getProductMainImg(pIdProduct NUMBER)
    RETURN VARCHAR2
    IS
        vPath VARCHAR2(100);
    BEGIN
        SELECT ph.picture INTO vPath
        FROM ProductPhoto pph
        LEFT JOIN Photo ph ON pph.id_productPhoto = ph.id_photo
        WHERE pph.id_product = pIdProduct;
        RETURN vPath;
    END getProductMainImg;
    
    PROCEDURE getProductPhotos(pIdProduct NUMBER, photoCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN photoCursor
        FOR
        SELECT ph.picture
        FROM productPhoto pph
        LEFT JOIN photo ph ON pph.id_productphoto = ph.id_photo
        WHERE pph.id_product = pIdProduct
        ORDER BY ph.id_photo ASC;
    END getProductPhotos;

END ProductPhoto_Utils;
