CREATE OR REPLACE PACKAGE idType_utils IS
    PROCEDURE insertType(pType IN VARCHAR2);
    
    PROCEDURE deleteType(pId IN NUMBER);
    
    PROCEDURE setType(pId IN NUMBER, pType IN VARCHAR2);
    
    FUNCTION  getType(pId IN NUMBER) RETURN VARCHAR2;
    PROCEDURE getTypes(typesCursor OUT SYS_REFCURSOR);
    
END idType_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY idType_utils AS

-- Insert
    PROCEDURE insertType(pType IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO identificationType (id_type, name)
            VALUES (s_identificationType.NEXTVAL, pType);
        COMMIT;
            
    EXCEPTION 
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END insertType;
    
-- Delete
    PROCEDURE deleteType(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM identificationType
        WHERE id_type = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es válido');
            ROLLBACK;
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END deleteType;

-- Setters
    PROCEDURE setType(pId IN NUMBER, pType IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE identificationType
        SET name = pType
        WHERE id_type = pId;
        COMMIT;
        
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el nombre ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
        
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
        
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es válido');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el nombre ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    END getType;
    
    PROCEDURE getTypes(typesCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN typesCursor
        FOR
        SELECT id_type, name
        FROM IdentificationType;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getTypes;

END idType_utils;