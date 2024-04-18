CREATE OR REPLACE PACKAGE photo_utils IS
    PROCEDURE insertPhoto(pDir IN VARCHAR2, pName IN VARCHAR2);
    
    PROCEDURE setPhoto(pId IN NUMBER, pDir IN VARCHAR2, pName IN VARCHAR2);
    
    FUNCTION  getPhoto(pId IN NUMBER) RETURN BFILE;

END photo_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY photo_utils AS

-- Insert
    PROCEDURE insertPhoto(pDir IN VARCHAR2, pName IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO photo (id_photo, picture)
            VALUES (s_photo.NEXTVAL, BFILENAME(pDir, pName));
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
    PROCEDURE setPhoto(pId IN NUMBER, pDir IN VARCHAR2, pName IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE photo
        SET picture = BFILENAME(pDir, pName)
        WHERE id_photo = pId;
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    
    END;

-- Getters
    FUNCTION getPhoto(pId IN NUMBER)
    RETURN BFILE
    IS
        vPicture    BFILE;
    
    BEGIN
        SELECT picture
        INTO vPicture
        FROM photo
        WHERE id_photo = pId;
        RETURN (vPicture);
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            DBMS_OUTPUT.PUT_LINE('El valor ingresado no es un número');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el registro con el id '|| pId);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
    
    END;

END photo_utils;