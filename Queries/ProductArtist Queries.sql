CREATE OR REPLACE PACKAGE productArtist_utils IS
    PROCEDURE insertProductArtist(pProduct IN NUMBER, pArtist IN NUMBER);
    
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setArtist(pId IN NUMBER, pArtist IN NUMBER);
    
    FUNCTION  getProduct(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getArtist(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getAllProducts(pArtist IN NUMBER) RETURN SYS_REFCURSOR;
    FUNCTION  getAllArtists(pProduct IN NUMBER) RETURN SYS_REFCURSOR;

END productArtist_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY productArtist_utils aS

-- Insert
    PROCEDURE insertProductArtist(pProduct IN NUMBER, pArtist IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO productArtist (id_productArtist, id_product, id_artist)
            VALUES (s_productArtist.NEXTVAL, pProduct, pArtist);
        COMMIT;
        
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
-- Setters
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER)
    IS
    
    BEGIN
        UPDATE productArtist
        SET id_product = pProduct
        WHERE id_productArtist = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setArtist(pId IN NUMBER, pArtist IN NUMBER)
    IS
    
    BEGIN
        UPDATE productArtist
        SET id_artist = pArtist
        WHERE id_productArtist = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
-- Getters
    FUNCTION getProduct(pId IN NUMBER)
    RETURN NUMBER
    IS
        vProduct    NUMBER(6);
    
    BEGIN
        SELECT id_product
        INTO vProduct
        FROM productArtist
        WHERE id_productArtist = pId;
        RETURN (vProduct);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getArtist(pId IN NUMBER)
    RETURN NUMBER
    IS
        vArtist     NUMBER(6);
    
    BEGIN
        SELECT id_artist
        INTO vArtist
        FROM productArtist
        WHERE id_productArtist = pId;
        RETURN (vArtist);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getAllProducts(pArtist IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        productCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN productCursor FOR
            SELECT id_product
            FROM productArtist
            WHERE id_artist = pArtist;
        RETURN (productCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro con el artista '||
                                 pArtist);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getAllArtists(pProduct IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        artistCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN artistCursor FOR
            SELECT id_artist
            FROM productArtist
            WHERE id_product = pProduct;
        RETURN (artistCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro con el producto '||
                                 pProduct);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END productArtist_utils;