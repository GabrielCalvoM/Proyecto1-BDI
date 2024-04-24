CREATE OR REPLACE PACKAGE category_utils IS
    PROCEDURE insertCategory(pName IN VARCHAR2);
    
    PROCEDURE deleteCategory(pId IN NUMBER);
    
    PROCEDURE setCategory(pId IN NUMBER, pName IN VARCHAR2);
    
    FUNCTION  getCategory(pId IN NUMBER) RETURN VARCHAR2;
    PROCEDURE getCategorys(categorysCursor OUT SYS_REFCURSOR);
    
END category_utils;
/

-- L�gica de procedimientos
CREATE OR REPLACE PACKAGE BODY category_utils AS

-- Insert
    PROCEDURE insertCategory(pName IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO category (id_category, name)
            VALUES (s_category.NEXTVAL, pName);
        COMMIT;

    END;
    
-- Delete
    PROCEDURE deleteCategory(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM category
        WHERE id_category = pId;
        COMMIT;
    
    END;

-- Setters
    PROCEDURE setCategory(pId IN NUMBER, pName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE category
        SET name = pName
        WHERE id_category = pId;
        COMMIT;
    
    END;

-- Getters
    FUNCTION  getCategory(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vName     VARCHAR2(20);
    
    BEGIN
        SELECT name INTO vName
        FROM category
        WHERE id_category = pId;
        RETURN (vName);
    
    END;
    
    PROCEDURE getCategorys(categorysCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN categorysCursor
        FOR
        SELECT id_category, name
        FROM Category;

    END getCategorys;

END category_utils;