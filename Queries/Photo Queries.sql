CREATE OR REPLACE PACKAGE photo_utils IS
    FUNCTION insertPhoto(pPath IN VARCHAR2) RETURN NUMBER;
    
    PROCEDURE removePhoto(pId NUMBER);
    
    FUNCTION  getPhoto(pId IN NUMBER) RETURN VARCHAR2;

END photo_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY photo_utils AS

-- Insert
    FUNCTION insertPhoto(pPath VARCHAR2)
    RETURN NUMBER
    IS
        vId_Photo NUMBER;
    BEGIN
        SELECT s_photo.NEXTVAL INTO vId_Photo FROM DUAL;
        INSERT INTO photo(id_photo, picture)
        VALUES (vId_Photo, pPath);
        COMMIT;
        RETURN vId_Photo;
    
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
    END insertPhoto;
    
    PROCEDURE removePhoto(pId NUMBER)
    IS
    BEGIN
        DELETE FROM Photo
        WHERE id_photo = pId;
        COMMIT;
    END removePhoto;

-- Getters
    FUNCTION getPhoto(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vPicture VARCHAR2(100);
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
    
    END getPhoto;

END photo_utils;