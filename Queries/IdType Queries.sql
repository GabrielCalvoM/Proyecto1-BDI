CREATE OR REPLACE PACKAGE idType_utils IS
    PROCEDURE insertType(pType IN VARCHAR2);
    
    PROCEDURE deleteType(pId IN NUMBER);
    
    PROCEDURE setType(pId IN NUMBER, pType IN VARCHAR2);
    
    FUNCTION  getType(pId IN NUMBER) RETURN VARCHAR2;
    PROCEDURE getTypes(typesCursor OUT SYS_REFCURSOR);
    
END idType_utils;
/

-- L�gica de Procedimientos
CREATE OR REPLACE PACKAGE BODY idType_utils AS

-- Insert
    PROCEDURE insertType(pType IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO identificationType (id_type, name)
            VALUES (s_identificationType.NEXTVAL, pType);
        COMMIT;
        
            
    END insertType;
    
-- Delete
    PROCEDURE deleteType(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM identificationType
        WHERE id_type = pId;
        COMMIT;
            
    END deleteType;

-- Setters
    PROCEDURE setType(pId IN NUMBER, pType IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE identificationType
        SET name = pType
        WHERE id_type = pId;
        COMMIT;

    END setType;
    
-- Getters
    FUNCTION getType(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vName     VARCHAR2(20);
        
    BEGIN
        SELECT name INTO vName
        FROM gender
        WHERE id_gender = pId;
        RETURN (vName);
        

    END getType;
    
    PROCEDURE getTypes(typesCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN typesCursor
        FOR
        SELECT id_type, name
        FROM IdentificationType;

    END getTypes;

END idType_utils;