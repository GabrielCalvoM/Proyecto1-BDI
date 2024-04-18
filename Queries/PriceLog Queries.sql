CREATE OR REPLACE PACKAGE priceLog_utils IS
    PROCEDURE insertPriceLog(pPrevPrice IN NUMBER, pPostPrice IN NUMBER,
                             pChangeDate IN DATE, pProduct IN NUMBER,
                             pPlatform IN NUMBER);
    
    PROCEDURE setPrevPrice(pId IN NUMBER, pPrice IN NUMBER);
    PROCEDURE setPostPrice(pId IN NUMBER, pPrice IN NUMBER);
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setPlatform(pId IN NUMBER, pPlatform IN NUMBER);
    
    FUNCTION  getPrevPrice(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getPostPrice(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getChangeDate(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getProduct(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getPlatform(pId IN NUMBER) RETURN NUMBER;

END priceLog_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY priceLog_utils AS

-- Insert
    PROCEDURE insertPriceLog(pPrevPrice IN NUMBER, pPostPrice IN NUMBER,
                             pChangeDate IN DATE, pProduct IN NUMBER,
                             pPlatform IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO priceLog (id_log, previous_price, later_price, change_date,
                              id_product, id_streamPlatform)
            VALUES (s_priceLog.NEXTVAL, pPrevPrice, pPostPrice, pChangeDate,
                    pProduct, pPlatform);
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
    PROCEDURE setPrevPrice(pId IN NUMBER, pPrice IN NUMBER)
    IS
    
    BEGIN
        UPDATE priceLog
        SET previous_price = pPrice
        WHERE id_log = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setPostPrice(pId IN NUMBER, pPrice IN NUMBER)
    IS
    
    BEGIN
        UPDATE priceLog
        SET later_price = pPrice
        WHERE id_log = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER)
    IS
    
    BEGIN
        UPDATE priceLog
        SET id_product = pProduct
        WHERE id_log = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setPlatform(pId IN NUMBER, pPlatform IN NUMBER)
    IS
    
    BEGIN
        UPDATE priceLog
        SET id_streamPlatform = pPlatform
        WHERE id_log = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;

-- Getters
    FUNCTION getPrevPrice(pId IN NUMBER)
    RETURN NUMBER
    IS
        vPrevPrice  NUMBER(5, 3);
    
    BEGIN
        SELECT previous_price
        INTO vPrevPrice
        FROM priceLog
        WHERE id_log = pId;
        RETURN (vPrevPrice);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getPostPrice(pId IN NUMBER)
    RETURN NUMBER
    IS
        vPostPrice  NUMBER(5, 3);
    
    BEGIN
        SELECT later_price
        INTO vPostPrice
        FROM priceLog
        WHERE id_log = pId;
        RETURN (vPostPrice);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION  getChangeDate(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vChangeDate  VARCHAR2(10);
    
    BEGIN
        SELECT TO_CHAR(change_date, 'DD-MM-YYYY')
        INTO vChangeDate
        FROM priceLog
        WHERE id_log = pId;
        RETURN (vChangeDate);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getProduct(pId IN NUMBER)
    RETURN NUMBER
    IS
        vProduct    NUMBER(6);
    
    BEGIN
        SELECT id_product
        INTO vProduct
        FROM priceLog
        WHERE id_log = pId;
        RETURN (vProduct);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION getPlatform(pId IN NUMBER)
    RETURN NUMBER
    IS
        vPlatform    NUMBER(6);
    
    BEGIN
        SELECT id_streamPlatform
        INTO vPlatform
        FROM priceLog
        WHERE id_log = pId;
        RETURN (vPlatform);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END priceLog_utils;