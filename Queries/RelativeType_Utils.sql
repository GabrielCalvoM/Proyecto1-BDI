CREATE OR REPLACE PACKAGE RelativeType_Utils IS
    -- Insert
    PROCEDURE insertRelativeType(pName VARCHAR);
    -- Delete
    PROCEDURE deleteRelativeType(pId NUMBER);
    -- Update
    PROCEDURE updateRelativeTypeName (pId NUMBER, pName VARCHAR2);
    -- Getters
    FUNCTION getRelativeTypeName (pId NUMBER) RETURN VARCHAR2;
    
    PROCEDURE getRelativeTypes(RelativeTypesCursor OUT SYS_REFCURSOR);

END RelativeType_Utils;
/

CREATE OR REPLACE PACKAGE BODY RelativeType_Utils AS
    -- Insert
    PROCEDURE insertRelativeType(pName VARCHAR)
    IS
    BEGIN
        INSERT INTO proy1.RelativeType (id_RelativeType, name_RelativeType)
               VALUES (s_RelativeType.nextval, pName);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END insertRelativeType;

    -- Delete
    PROCEDURE deleteRelativeType(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.RelativeType
        WHERE id_RelativeType = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteRelativeType;
    
    -- Update
    PROCEDURE updateRelativeTypeName (pId NUMBER, pName VARCHAR2)
    IS
        BEGIN
        UPDATE proy1.RelativeType
        SET name_RelativeType = pName
        WHERE id_RelativeType = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END updateRelativeTypeName;
    
    -- Getter
    FUNCTION getRelativeTypeName (pId NUMBER) RETURN VARCHAR2
    IS
        vName VARCHAR(20);
    BEGIN
        SELECT name_RelativeType INTO vName
        FROM RelativeType
        WHERE id_RelativeType = pId;
        RETURN vName;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getRelativeTypeName;
    
    PROCEDURE getRelativeTypes(RelativeTypesCursor OUT SYS_REFCURSOR)
    IS
    BEGIN 
        OPEN RelativeTypesCursor
        FOR
        SELECT id_relativeType, name_relativeType
        FROM RelativeType;

    END getRelativeTypes;
    
END RelativeType_Utils;
