CREATE OR REPLACE PACKAGE StreamPlatform_Utils IS
    -- Insert
    PROCEDURE insertStreamPlatform(pId NUMBER, pName VARCHAR2);
    -- Delete
    PROCEDURE deleteStreamPlatform(pId NUMBER);
    -- Update
    PROCEDURE updateStreamPlatformName (pId NUMBER, pName VARCHAR2);
    -- Getter
    FUNCTION getStreamPlatformName (pId NUMBER) RETURN VARCHAR2;
END StreamPlatform_Utils;
/

CREATE OR REPLACE PACKAGE BODY StreamPlatform_Utils AS
    -- Insert
    PROCEDURE insertStreamPlatform(pId NUMBER, pName VARCHAR2)
    IS
    BEGIN
        INSERT INTO proy1.StreamPlatform (id_StreamPlatform, name)
               VALUES (s_StreamPlatform.nextval, pName);
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END insertStreamPlatform;

    -- Delete
    PROCEDURE deleteStreamPlatform(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.StreamPlatform
        WHERE id_StreamPlatform = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END deleteStreamPlatform;
    
    -- Update
    PROCEDURE updateStreamPlatformName (pId NUMBER, pName VARCHAR2)
    IS
        BEGIN
        UPDATE proy1.StreamPlatform
        SET name = pName
        WHERE id_StreamPlatform = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END updateStreamPlatformName;
    
    -- Getter
    FUNCTION getStreamPlatformName (pId NUMBER) RETURN VARCHAR2
    IS
        vName VARCHAR(20);
    BEGIN
        SELECT name INTO vName
        FROM StreamPlatform
        WHERE id_StreamPlatform = pId;
        RETURN vName;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getStreamPlatformName;
    
END StreamPlatform_Utils;
