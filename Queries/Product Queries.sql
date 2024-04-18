CREATE OR REPLACE PACKAGE product_utils IS
    PROCEDURE insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                            pDuration IN TIMESTAMP, pSynopsis IN VARCHAR2,
                            pTrailer IN VARCHAR2);
                            
    PROCEDURE setTitle(pId IN NUMBER, pTitle IN VARCHAR2);
    PROCEDURE setYear(pId IN NUMBER, pYear IN NUMBER);
    PROCEDURE setDuration(pId IN NUMBER, pDuration IN TIMESTAMP);
    PROCEDURE setSynopsis(pId IN NUMBER, pSynopsis IN VARCHAR2);
    PROCEDURE setTrailer(pId IN NUMBER, pTrailer IN VARCHAR2);
    
    FUNCTION  getId RETURN NUMBER;
    FUNCTION  getTitle(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getYear(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getDuration(pId IN NUMBER) RETURN TIMESTAMP;
    FUNCTION  getSynopsis(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getTrailer(pId IN NUMBER) RETURN VARCHAR2;

END product_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY product_utils AS

-- Insert
    PROCEDURE insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                            pDuration IN TIMESTAMP, pSynopsis IN VARCHAR2,
                            pTrailer IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO product (id_product, title, premiere_year, film_duration,
                             synopsis, trailer)
            VALUES (s_product.NEXTVAL, pTitle, pYear, pDuration, pSynopsis,
                    pTrailer);
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
    PROCEDURE setTitle(pId IN NUMBER, pTitle IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE product
        SET title = pTitle
        WHERE id_product = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setYear(pId IN NUMBER, pYear IN NUMBER)
    IS
    
    BEGIN
        UPDATE product
        SET premiere_year = pYear
        WHERE id_product = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setDuration(pId IN NUMBER, pDuration IN TIMESTAMP)
    IS
    
    BEGIN
        UPDATE product
        SET film_duration = pDuration
        WHERE id_product = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setSynopsis(pId IN NUMBER, pSynopsis IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE product
        SET synopsis = pSynopsis
        WHERE id_product = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setTrailer(pId IN NUMBER, pTrailer IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE product
        SET trailer = pTrailer
        WHERE id_product = pId;
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
    FUNCTION getId
    RETURN NUMBER
    IS
        vId     NUMBER(6);
    
    BEGIN
        SELECT s_product.CURRVAL
        INTO vId
        FROM dual;
        RETURN (vId);
        
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
        
    END;
    
    FUNCTION getTitle(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vTitle      VARCHAR2(30);
        
    BEGIN
        SELECT title
        INTO vTitle
        FROM product
        WHERE id_product = pId;
        RETURN (vTitle);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getYear(pId IN NUMBER)
    RETURN NUMBER
    IS
        vYear       NUMBER(30);
        
    BEGIN
        SELECT premiere_year
        INTO vYear
        FROM product
        WHERE id_product = pId;
        RETURN (vYear);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getDuration(pId IN NUMBER)
    RETURN TIMESTAMP
    IS
        vDuration   TIMESTAMP;
        
    BEGIN
        SELECT film_duration
        INTO vDuration
        FROM product
        WHERE id_product = pId;
        RETURN (vDuration);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getSynopsis(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vSynopsis   VARCHAR2(30);
        
    BEGIN
        SELECT synopsis
        INTO vSynopsis
        FROM product
        WHERE id_product = pId;
        RETURN (vSynopsis);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getTrailer(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vTrailer    VARCHAR2(30);
        
    BEGIN
        SELECT trailer
        INTO vTrailer
        FROM product
        WHERE id_product = pId;
        RETURN (vTrailer);
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El número ingresado es inválido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END product_utils;