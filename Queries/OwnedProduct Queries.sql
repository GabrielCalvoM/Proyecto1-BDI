CREATE OR REPLACE PACKAGE ownedProduct_utils IS
    PROCEDURE insertOwnedProduct(pProduct IN NUMBER, pUser IN NUMBER,
                                 pPurchase IN VARCHAR2);
    
    PROCEDURE deleteOwnedProduct(pId IN NUMBER);
    PROCEDURE deleteProduct(pId_product NUMBER);
                                 
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setUser(pId IN NUMBER, pUser IN NUMBER);
    
    FUNCTION  getProduct(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getUser(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getPurchase(pId IN NUMBER) RETURN VARCHAR2;
    
    PROCEDURE getOwnedProducts(pId_User NUMBER, productsCursor OUT SYS_REFCURSOR);
    PROCEDURE getProductsFilter(pId_User NUMBER, pMonths NUMBER, productsCursor OUT SYS_REFCURSOR);
    PROCEDURE getTopOwnedProducts(pTopN NUMBER, productsCursor OUT SYS_REFCURSOR);

END ownedProduct_utils;


-- Lógica de Procedimientos
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

        
    END insertOwnedProduct;
    
-- Delete
    PROCEDURE deleteOwnedProduct(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM ownedProduct
        WHERE id_ownedProduct = pId;
        COMMIT;
            
    END deleteOwnedProduct;
    
    PROCEDURE deleteProduct(pId_product NUMBER)
    IS
    BEGIN
        DELETE FROM ownedProduct
        WHERE id_ownedProduct = pId_product;
        COMMIT;   
    END deleteProduct;

-- Setters
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER)
    IS
    
    BEGIN
        UPDATE ownedProduct
        SET id_product = pProduct
        WHERE id_ownedProduct = pId;
        COMMIT;

    END setProduct;
    
    PROCEDURE setUser(pId IN NUMBER, pUser IN NUMBER)
    IS
    
    BEGIN
        UPDATE ownedProduct
        SET id_user = pUser
        WHERE id_ownedProduct = pId;
        COMMIT;
        
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

    END getPurchase;
    
    PROCEDURE getOwnedProducts(pId_User NUMBER, productsCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursor
        FOR
        SELECT id_product, date_bought
        FROM OwnedProduct
        WHERE id_user = pId_User
        ORDER BY date_bought DESC;
    END getOwnedProducts;
    
    PROCEDURE getProductsFilter(pId_User NUMBER, pMonths NUMBER, productsCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursor
        FOR
        SELECT id_product, date_bought
        FROM OwnedProduct
        WHERE id_user = pId_User AND
        date_bought >= ADD_MONTHS(SYSDATE, pMonths)
        ORDER BY date_bought DESC;
    END getProductsFilter;
    
    PROCEDURE getTopOwnedProducts(pTopN NUMBER, productsCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursor
        FOR
        SELECT id_product, num_owners FROM
            (SELECT id_product, COUNT(id_product) AS num_owners
            FROM OwnedProduct
            GROUP BY id_product
            ORDER BY num_owners DESC)
        WHERE ROWNUM <= pTopN;
    END getTopOwnedProducts;

END ownedProduct_utils;