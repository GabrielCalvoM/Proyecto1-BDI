CREATE OR REPLACE PACKAGE gender_utils IS
    PROCEDURE insertGender(pName IN VARCHAR2);
    
    PROCEDURE setGender(pId IN NUMBER, pName IN VARCHAR2);
    
    FUNCTION  getGender(pId IN NUMBER) RETURN VARCHAR2;
    
    PROCEDURE getGenders(gendersCursor OUT SYS_REFCURSOR);
    
END gender_utils;

-- Lógica de procedimientos
CREATE OR REPLACE PACKAGE BODY gender_utils AS

-- Insert
    PROCEDURE insertGender(pName IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO gender (id_gender, name)
            VALUES (s_gender.NEXTVAL, pName);
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
    PROCEDURE setGender(pId IN NUMBER, pName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE gender
        SET name = pName
        WHERE id_gender = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el nombre ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;

-- Getters
    FUNCTION  getGender(pId IN NUMBER)
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
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;
    
    PROCEDURE getGenders(gendersCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN gendersCursor
        FOR
        SELECT id_gender, name
        FROM Gender;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getGenders;

END gender_utils;