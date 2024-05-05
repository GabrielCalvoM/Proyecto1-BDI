CREATE OR REPLACE PACKAGE productCategory_utils IS
    PROCEDURE insertProductCategory(pProduct IN NUMBER, pCategory IN NUMBER);
    
    PROCEDURE deleteProductCategory(pId_Product IN NUMBER);
    
    PROCEDURE setProduct(pId IN NUMBER, pProduct IN NUMBER);
    PROCEDURE setCategory(pId IN NUMBER, pCategory IN NUMBER);
    
    FUNCTION  getAllProducts(pCategory IN NUMBER) RETURN SYS_REFCURSOR;
    FUNCTION  getAllCategories(pProduct IN NUMBER) RETURN SYS_REFCURSOR;
    
    FUNCTION getProductCategory(pId_Product NUMBER) RETURN VARCHAR2;

END productCategory_utils;
/

-- L�gica de Procedimientos
CREATE OR REPLACE PACKAGE BODY productCategory_utils IS

-- Insert
    PROCEDURE insertProductCategory(pProduct IN NUMBER, pCategory IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO productCategory (id_productCategory, id_product, id_category)
            VALUES (s_productCategory.NEXTVAL, pProduct, pCategory);
        COMMIT;
    END insertProductCategory;
    
-- Delete
    PROCEDURE deleteProductCategory(pId_Product IN NUMBER)
    IS
    BEGIN
        DELETE FROM ProductCategory
        WHERE id_product = pId_Product;
        COMMIT;            
    END deleteProductCategory;
    
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
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
    
    END setProduct;
    
    PROCEDURE setCategory(pId IN NUMBER, pCategory IN NUMBER)
    IS
    
    BEGIN
        UPDATE productCategory
        SET id_category = pCategory
        WHERE id_productCategory = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
            ROLLBACK;
    
    END setCategory;
    
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
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un n�mero');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� ningun registro con la categor�a '||
                                 pCategory);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
    
    END getAllProducts;
    
    FUNCTION  getAllCategories(pProduct IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        categoryCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN categoryCursor FOR
            SELECT id_productCategory, id_category
            FROM productCategory
            WHERE id_product = pProduct;
        RETURN (categoryCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un n�mero');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontr� ningun registro con el producto '||
                                 pProduct);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedi� un error inesperado');
    
    END getAllCategories;
    
    FUNCTION getProductCategory(pId_Product NUMBER) RETURN VARCHAR2
    IS
        vId_Category NUMBER;
        vCategory VARCHAR2(15);
    BEGIN
        SELECT id_category INTO vId_Category
        FROM ProductCategory
        WHERE id_product = pId_Product;
        SELECT name INTO vCategory
        FROM Category
        WHERE id_category = vId_Category;
        RETURN vCategory;
    END getProductCategory;

END productCategory_utils;