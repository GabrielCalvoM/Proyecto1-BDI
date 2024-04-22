CREATE OR REPLACE PACKAGE product_utils IS
    FUNCTION insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                            pSynopsis IN VARCHAR2,
                            pTrailer IN VARCHAR2) RETURN NUMBER;
    PROCEDURE removeProduct(pId NUMBER);
    PROCEDURE getProduct(pId NUMBER, pTitle OUT VARCHAR2, pPremiere OUT NUMBER, 
    pSynopsis OUT VARCHAR2, pTrailer OUT VARCHAR2);               

END product_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY product_utils AS

-- Insert
    FUNCTION insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                pSynopsis IN VARCHAR2, pTrailer IN VARCHAR2)
    RETURN NUMBER    
    IS
        vIdProduct NUMBER;
    BEGIN
        SELECT s_product.nextval INTO vIdProduct FROM DUAL;
        INSERT INTO product (id_product, title, premiere_year,
                             synopsis, trailer)
            VALUES (vIdProduct, pTitle, pYear, pSynopsis,
                    pTrailer);
        COMMIT;
        RETURN vIdProduct;
        
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE removeProduct(pId NUMBER)
    IS
    BEGIN
        DELETE FROM Product
        WHERE id_product = pId;
        COMMIT;
    END;
    
    PROCEDURE getProduct(pId NUMBER, pTitle OUT VARCHAR2, pPremiere OUT NUMBER, 
        pSynopsis OUT VARCHAR2, pTrailer OUT VARCHAR2)
    IS
    BEGIN 
        SELECT title, premiere_year, synopsis, trailer
        INTO pTitle, pPremiere, pSynopsis, pTrailer
        FROM Product
        WHERE id_product = pId;
    END getProduct;

END product_utils;