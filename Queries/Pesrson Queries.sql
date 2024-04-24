CREATE OR REPLACE PACKAGE person_utils IS
    FUNCTION insertPerson(pFirstName IN VARCHAR2, pLastName IN VARCHAR2,
                           pBirth IN VARCHAR2, pHeight IN NUMBER,
                           pGender IN NUMBER) RETURN NUMBER;
                           
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
    
    END;
            
-- Setters
    PROCEDURE setFirstName(pId IN NUMBER, pFirstName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET first_name = pFirstName
        WHERE id_person = pId;
        COMMIT;
        
            
    END;
    
    PROCEDURE setLastName(pId IN NUMBER, pLastName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET last_name = pLastName
        WHERE id_person = pId;
        COMMIT;
        
            
    END;
    
    PROCEDURE setBirth(pId IN NUMBER, pBirth IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE person
        SET birth_date = TO_DATE(pBirth, 'DD-MM-YYYY')
        WHERE id_person = pId;
        COMMIT;
            
    END;
    
    PROCEDURE setHeight(pId IN NUMBER, pHeight IN NUMBER)
    IS
    
    BEGIN
        UPDATE person
        SET height_artist = pHeight
        WHERE id_person = pId;
        COMMIT;
            
    END;
    
    PROCEDURE setGender(pId IN NUMBER, pGender IN NUMBER)
    IS
    
    BEGIN
        UPDATE person
        SET id_gender = pGender
        WHERE id_person = pId;
        COMMIT;
    END;

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
    END;
    
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
    END;
    
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
    END;
    
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
    END;
    
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
    END;
    
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
    END;
    
END person_utils;