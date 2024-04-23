CREATE OR REPLACE PACKAGE person_utils IS
    FUNCTION insertPerson(pFirstName IN VARCHAR2, pLastName IN VARCHAR2,
                           pBirth IN VARCHAR2, pHeight IN NUMBER,
                           pGender IN NUMBER) RETURN NUMBER;
                           
    PROCEDURE deletePerson(pId IN NUMBER);
                           
    PROCEDURE setFirstName(pId IN NUMBER, pFirstName IN VARCHAR2);
    PROCEDURE setLastName(pId IN NUMBER, pLastName IN VARCHAR2);
    PROCEDURE setBirth(pId IN NUMBER, pBirth IN VARCHAR2);
    PROCEDURE setHeight(pId IN NUMBER, pHeight IN NUMBER);
    PROCEDURE setGender(pId IN NUMBER, pGender IN NUMBER);
    
    FUNCTION  getId RETURN NUMBER;
    FUNCTION  getFirstName(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getLastName(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getBirth(pId IN NUMBER) RETURN VARCHAR2;
    FUNCTION  getHeight(pId IN NUMBER) RETURN NUMBER;
    FUNCTION  getGender(pId IN NUMBER) RETURN NUMBER;

END person_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY person_utils AS

-- Insert
    FUNCTION insertPerson(pFirstName IN VARCHAR2, pLastName IN VARCHAR2,
                           pBirth IN VARCHAR2, pHeight IN NUMBER,
                           pGender IN NUMBER)
    RETURN NUMBER                            
    IS
        vIdPerson NUMBER;
    BEGIN
        SELECT s_person.NEXTVAL INTO vIdPerson FROM DUAL;
        INSERT INTO person (id_person, first_name, last_name, birth_date,
                            height_artist, id_gender)
            VALUES (vIdPerson, pFirstName, pLastName,
                    TO_DATE(pBirth, 'DD-MM-YYYY'), pHeight, pGender);
        COMMIT;
        RETURN vIdPerson;
    
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END insertPerson;
    
-- Delete
    PROCEDURE deletePerson(pId IN NUMBER)
    IS
    
    BEGIN
        DELETE FROM person
        WHERE id_person = pId;
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
            
    END deletePerson;
            
-- Setters
    PROCEDURE setFirstName(pId IN NUMBER, pFirstName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET first_name = pFirstName
        WHERE id_person = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setFirstName;
    
    PROCEDURE setLastName(pId IN NUMBER, pLastName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET last_name = pLastName
        WHERE id_person = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setLastName;
    
    PROCEDURE setBirth(pId IN NUMBER, pBirth IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET birth_date = TO_DATE(pBirth, 'DD-MM-YYYY')
        WHERE id_person = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setBirth;
    
    PROCEDURE setHeight(pId IN NUMBER, pHeight IN NUMBER)
    IS
    
    BEGIN
        UPDATE person
        SET height_artist = pHeight
        WHERE id_person = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setHeight;
    
    PROCEDURE setGender(pId IN NUMBER, pGender IN NUMBER)
    IS
    
    BEGIN
        UPDATE person
        SET id_gender = pGender
        WHERE id_person = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
            
    END setGender;

-- Getters
    FUNCTION getId
    RETURN NUMBER
    IS
        vId         VARCHAR2(30);
    
    BEGIN
        SELECT s_person.CURRVAL
        INTO vId
        FROM dual;
        COMMIT;
        RETURN (vId);
        
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getId;
    
    FUNCTION getFirstName(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vFirstName  VARCHAR2(30);
    
    BEGIN
        SELECT first_name
        INTO vFirstName
        FROM person
        WHERE id_person = pId;
        RETURN (vFirstName);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            
    END getFirstName;
    
    FUNCTION getLastName(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vLastName  VARCHAR2(30);
    
    BEGIN
        SELECT last_name
        INTO vLastName
        FROM person
        WHERE id_person = pId;
        RETURN (vLastName);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getLastName;
    
    FUNCTION getBirth(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vBirth      VARCHAR2(30);
    
    BEGIN
        SELECT birth_date
        INTO vBirth
        FROM person
        WHERE id_person = pId;
        RETURN (vBirth);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getBirth;
    
    FUNCTION getHeight(pId IN NUMBER)
    RETURN NUMBER
    IS
        vHeight     NUMBER(30);
    
    BEGIN
        SELECT height_artist
        INTO vHeight
        FROM person
        WHERE id_person = pId;
        RETURN (vHeight);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getHeight;
    
    FUNCTION getGender(pId IN NUMBER)
    RETURN NUMBER
    IS
        vGender     NUMBER(1);
    
    BEGIN
        SELECT id_gender
        INTO vGender
        FROM person
        WHERE id_person = pId;
        RETURN (vGender);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id ' || pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END getGender;
    
END person_utils;