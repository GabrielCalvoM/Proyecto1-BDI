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

--
    PROCEDURE insertProductCategory(pProduct IN NUMBER, pCategory IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO productCategory (id_productCategory, id_product, id_category)
            VALUES (s_productCategory.NEXTVAL, pProduct, pCategory);
        COMMIT;
    END insertProductCategory;
    
--
    PROCEDURE deleteProductCategory(pId_Product IN NUMBER)
    IS
    BEGIN
        DELETE FROM ProductCategory
        WHERE id_product = pId_Product;
        COMMIT;            
    END deleteProductCategory;
    
--
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