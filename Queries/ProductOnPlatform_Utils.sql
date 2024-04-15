CREATE OR REPLACE PACKAGE ProductOnPlatform_Utils IS
    -- Insert
    PROCEDURE insertProductOnPlatform(pId NUMBER, pPrice NUMBER, pId_Product NUMBER, pId_Stream NUMBER);
    -- Delete
    PROCEDURE deleteProductOnPlatform(pId NUMBER);
    -- Update
    PROCEDURE updatePrice(pId NUMBER, pPrice NUMBER);
    -- Getter
    FUNCTION getPrice(pId NUMBER) RETURN NUMBER;
END ProductOnPlatform_Utils;
/

CREATE OR REPLACE PACKAGE BODY ProductOnPlatform_Utils AS
    -- Insert
    PROCEDURE insertProductOnPlatform(pId NUMBER, pPrice NUMBER, pId_Product NUMBER, pId_Stream NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ProductOnPlatform (id_ProductOnPlatform, price, id_product, id_streamPlatform)
               VALUES (s_ProductOnPlatform.nextval, pPrice, pId_Product, pId_Stream);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');

    END insertProductOnPlatform;

    -- Delete
    PROCEDURE deleteProductOnPlatform(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ProductOnPlatform
        WHERE id_ProductOnPlatform = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END deleteProductOnPlatform;

    -- Update
    PROCEDURE updatePrice(pId NUMBER, pPrice NUMBER)
    IS
    BEGIN
        UPDATE proy1.ProductOnPlatform
        SET price = pPrice
        WHERE id_ProductOnPlatform = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END updatePrice;

    -- Getter
    FUNCTION getPrice(pId NUMBER) RETURN NUMBER
    IS
        vPrice NUMBER;
    BEGIN
        SELECT price INTO vPrice
        FROM proy1.ProductOnPlatform 
        WHERE id_ProductOnPlatform = pId;
        RETURN vPrice;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';

    END getPrice;

END ProductOnPlatform_Utils;
