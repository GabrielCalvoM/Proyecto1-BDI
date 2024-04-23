CREATE OR REPLACE PACKAGE ownedProduct_utils IS
    PROCEDURE insertOwnedProduct(pProduct IN NUMBER, pUser IN NUMBER,
                                 pPurchase IN VARCHAR2);
    
    PROCEDURE deleteOwnedProduct(pId IN NUMBER);
                                 
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setUser(pId IN NUMBER, pUser IN NUMBER);
    
    FUNCTION  getProduct(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getUser(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getPurchase(pId IN NUMBER) RETURN VARCHAR2;

END ownedProduct_utils;
/

-- L�gica de Procedimientos
CREATE OR REPLACE PACKAGE BODY ownedProduct_utils AS

-- Insert
    PROCEDURE insertOwnedProduct(pProduct IN NUMBER, pUser IN NUMBER,
                                 pPurchase IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO ownedProduct(id_ownedProduct, id_product, id_user, date_bought)
            VALUES (s_ownedProduct.NEXTVAL, pProduct, pUser,
                    TO_DATE(pPurchase, 'DD-MM-YYYY'));
        COMMIT;
    
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los par�metros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
        
    END insertOwnedProduct;
    
-- Delete
    PROCEDURE deleteOwnedProduct(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM ownedProduct
        WHERE id_ownedProduct = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es v�lido');
            ROLLBACK;
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
            
    END deleteOwnedProduct;

-- Setters
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER)
    IS
    
    BEGIN
        UPDATE ownedProduct
        SET id_product = pProduct
        WHERE id_ownedProduct = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
    
    END setProduct;
    
    PROCEDURE setUser(pId IN NUMBER, pUser IN NUMBER)
    IS
    
    BEGIN
        UPDATE ownedProduct
        SET id_user = pUser
        WHERE id_ownedProduct = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
    
    END setUser;

-- Getters
    FUNCTION getProduct(pId IN NUMBER)
    RETURN NUMBER
    IS
        vProduct    NUMBER(6);
    
    BEGIN
        SELECT id_product
        INTO vProduct
        FROM ownedProduct
        WHERE id_ownedProduct = pId;
        RETURN (vProduct);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
    
    END getProduct;
    
    FUNCTION getUser(pId IN NUMBER)
    RETURN NUMBER
    IS
        vUser    NUMBER(6);
    
    BEGIN
        SELECT id_user
        INTO vUser
        FROM ownedProduct
        WHERE id_ownedProduct = pId;
        RETURN (vUser);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
    
    END getUser;
    
    FUNCTION getPurchase(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vPurchase   VARCHAR2(10);
    
    BEGIN
        SELECT TO_CHAR(date_bought, 'DD-MM-YYYY')
        INTO vPurchase
        FROM ownedProduct
        WHERE id_ownedProduct = pId;
        RETURN (vPurchase);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
    
    END getPurchase;

END ownedProduct_utils;