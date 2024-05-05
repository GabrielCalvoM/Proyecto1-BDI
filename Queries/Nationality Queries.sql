CREATE OR REPLACE PACKAGE nationality_utils IS
    PROCEDURE insertNationality(pIdPerson IN NUMBER, pIdCountry IN NUMBER);
    
    PROCEDURE deleteNationality(pIdCountry IN NUMBER, pIdPerson IN NUMBER);
    
    PROCEDURE setPerson(pIdNationality IN NUMBER, pIdPerson IN NUMBER);
    PROCEDURE setCountry(pIdNationality IN NUMBER, pIdCountry IN NUMBER);
    
    FUNCTION  getAllNationalities(pIdPerson IN NUMBER) RETURN SYS_REFCURSOR;

END nationality_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY nationality_utils AS

-- Insert
    PROCEDURE insertNationality(pIdPerson IN NUMBER, pIdCountry IN NUMBER)
    IS
    
    BEGIN
        INSERT INTO nationality (id_nationality, id_person, id_country)
            VALUES (s_nationality.NEXTVAL, pIdPerson, pIdCountry);
        COMMIT;
        
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END insertNationality;
    
-- Delete
    PROCEDURE deleteNationality(pIdCountry IN NUMBER, pIdPerson IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM nationality
        WHERE id_person = pIdPerson
        AND id_country = pIdCountry;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es válido');
            ROLLBACK;
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END deleteNationality;

-- Setters
    PROCEDURE setPerson(pIdNationality IN NUMBER, pIdPerson IN NUMBER)
    IS
    
    BEGIN
        UPDATE nationality
        SET id_person = pIdPerson
        WHERE id_nationality = pIdNationality;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' ||
                                 pIdNationality);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setPerson;
    
    PROCEDURE setCountry(pIdNationality IN NUMBER, pIdCountry IN NUMBER)
    IS
    
    BEGIN
        UPDATE nationality
        SET id_country = pIdCountry
        WHERE id_nationality = pIdNationality;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' ||
                                 pIdNationality);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setCountry;

-- Getters
    FUNCTION getAllNationalities(pIdPerson IN NUMBER)
    RETURN SYS_REFCURSOR
    IS
        nationalityCursor   SYS_REFCURSOR;
    
    BEGIN
        OPEN nationalityCursor FOR
            SELECT id_country
            FROM nationality
            WHERE id_person = pIdPerson;
        RETURN (nationalityCursor);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró ningun registro de la persona ' ||
                                 pIdPerson);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getAllNationalities;

END nationality_utils;