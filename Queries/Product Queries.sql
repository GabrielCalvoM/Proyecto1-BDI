CREATE OR REPLACE PACKAGE product_utils IS
    FUNCTION insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                            pSynopsis IN VARCHAR2, pTrailer IN VARCHAR2, 
                            pPrice NUMBER) RETURN NUMBER;
    PROCEDURE removeProduct(pId NUMBER);
    PROCEDURE getProduct(pId NUMBER, pTitle OUT VARCHAR2, pPremiere OUT NUMBER, 
    pSynopsis OUT VARCHAR2, pTrailer OUT VARCHAR2, pPrice OUT NUMBER);               

END product_utils;

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY product_utils AS

-- Insert
    FUNCTION insertProduct(pTitle IN VARCHAR2, pYear IN NUMBER,
                pSynopsis IN VARCHAR2, pTrailer IN VARCHAR2, pPrice NUMBER)
    RETURN NUMBER    
    IS
        vIdProduct NUMBER;
    BEGIN
        SELECT s_product.nextval INTO vIdProduct FROM DUAL;
        INSERT INTO product (id_product, title, premiere_year,
                             synopsis, trailer, price)
            VALUES (vIdProduct, pTitle, pYear, pSynopsis,
                    pTrailer, pPrice);
        COMMIT;
        RETURN vIdProduct;
    
    END;
    
    PROCEDURE removeProduct(pId NUMBER)
    IS
    BEGIN
        DELETE FROM ProductCategory
        WHERE id_product = pId;
        DELETE FROM WishedProduct
        WHERE id_product = pId;
        DELETE FROM CartProduct
        WHERE id_Product = pId;
        DELETE FROM Product
        WHERE id_product = pId;
        COMMIT;
    END;
    
    PROCEDURE getProduct(pId NUMBER, pTitle OUT VARCHAR2, pPremiere OUT NUMBER, 
        pSynopsis OUT VARCHAR2, pTrailer OUT VARCHAR2, pPrice OUT NUMBER)
    IS
    BEGIN 
        SELECT title, premiere_year, synopsis, trailer, price
        INTO pTitle, pPremiere, pSynopsis, pTrailer, pPrice
        FROM Product
        WHERE id_product = pId;
    END getProduct;

END product_utils;