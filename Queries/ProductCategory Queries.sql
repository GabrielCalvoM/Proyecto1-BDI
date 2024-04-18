CREATE OR REPLACE PACKAGE productCategory_utils IS
    PROCEDURE insertProductCategory(pProduct IN NUMBER, pCategory IN NUMBER);
    
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setCategory(pId IN NUMBER, pCategory IN NUMBER);
    
    FUNCTION  getAllProducts(pCategory IN NUMBER) RETURN SYS_REFCURSOR;
    FUNCTION  getAllCategories(pProduct IN NUMBER) RETURN SYS_REFCURSOR;

END productCategory_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY productCategory_utils IS

-- Insert
    PROCEDURE insertProductCategory(pProduct IN NUMBER, pCategory IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO productCategory (id_productCategory, id_product, id_category)
            VALUES (s_productCategory.NEXTVAL, pProduct, pCategory);
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
        UPDATE productCategory
        SET id_product = pProduct
        WHERE id_productCategory = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;
    
    PROCEDURE setCategory(pId IN NUMBER, pCategory IN NUMBER)
    IS
    
    BEGIN
        UPDATE productCategory
        SET id_category = pCategory
        WHERE id_productCategory = pId;
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
    FUNCTION  getAllProducts(pCategory IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        productCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN productCursor FOR
            SELECT id_product
            FROM productCategory
            WHERE id_category = pCategory;
        RETURN (productCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro con la categoría '||
                                 pCategory);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    FUNCTION  getAllCategories(pProduct IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        categoryCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN categoryCursor FOR
            SELECT id_category
            FROM productCategory
            WHERE id_product = pProduct;
        RETURN (categoryCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro con el producto '||
                                 pProduct);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END productCategory_utils;