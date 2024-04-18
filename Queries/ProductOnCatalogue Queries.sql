CREATE OR REPLACE PACKAGE productOnCatalogue_utils IS
    PROCEDURE insertProductOnCatalogue(pProduct IN NUMBER, pCatalogue IN NUMBER);
    
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setCatalogue(pId IN NUMBER, pCatalogue IN NUMBER);
    
    FUNCTION  getAllProducts(pCatalogue IN NUMBER) RETURN SYS_REFCURSOR;
    FUNCTION  getAllCatalogues(pProduct IN NUMBER) RETURN SYS_REFCURSOR;

END productOnCatalogue_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY productOnCatalogue_utils IS

-- Insert
    PROCEDURE insertProductOnCatalogue(pProduct IN NUMBER, pCatalogue IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO productOnCatalogue (id_productOnCatalogue, id_product,
                                        id_catalogue)
            VALUES (s_productOnCatalogue.NEXTVAL, pProduct, pCatalogue);
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
        UPDATE productOnCatalogue
        SET id_product = pProduct
        WHERE id_productOnCatalogue = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setCatalogue(pId IN NUMBER, pCatalogue IN NUMBER)
    IS
    
    BEGIN
        UPDATE productOnCatalogue
        SET id_catalogue = pCatalogue
        WHERE id_productOnCatalogue = pId;
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
    FUNCTION  getAllProducts(pCatalogue IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        productCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN productCursor FOR
            SELECT id_product
            FROM productOnCatalogue
            WHERE id_catalogue = pCatalogue;
        RETURN (productCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro en el catalogo '||
                                 pCatalogue);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION  getAllCatalogues(pProduct IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        catalogueCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN catalogueCursor FOR
            SELECT id_catalogue
            FROM productOnCatalogue
            WHERE id_product = pProduct;
        RETURN (catalogueCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro con el producto '||
                                 pProduct);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END productOnCatalogue_utils;