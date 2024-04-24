CREATE OR REPLACE PACKAGE gender_utils IS
    PROCEDURE insertGender(pName IN VARCHAR2);
    
    PROCEDURE setGender(pId IN NUMBER, pName IN VARCHAR2);
    
    FUNCTION  getGender(pId IN NUMBER) RETURN VARCHAR2;
    
    PROCEDURE getGenders(gendersCursor OUT SYS_REFCURSOR);
    
END gender_utils;
/

-- Lógica de procedimientos
CREATE OR REPLACE PACKAGE BODY gender_utils AS

-- Insert
    PROCEDURE insertGender(pName IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO gender (id_gender, name)
            VALUES (s_gender.NEXTVAL, pName);
    COMMIT;

    END;

-- Setters
    PROCEDURE setGender(pId IN NUMBER, pName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE gender
        SET name = pName
        WHERE id_gender = pId;
        COMMIT;
    
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
    
    END;
    
    PROCEDURE getGenders(gendersCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN gendersCursor
        FOR
        SELECT id_gender, name
        FROM Gender;

    END getGenders;

END gender_utils;