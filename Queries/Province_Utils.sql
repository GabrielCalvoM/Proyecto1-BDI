CREATE OR REPLACE PACKAGE Province_Utils IS
    -- Insert
    PROCEDURE insertProvince(pId NUMBER, pName VARCHAR2, pId_Country NUMBER);
    -- Delete
    PROCEDURE deleteProvince(pId NUMBER);
    -- Update
    PROCEDURE updateProvinceName (pId NUMBER, pName VARCHAR2);
    -- Getter
    FUNCTION getProvinceName (pId NUMBER) RETURN VARCHAR2;
END Province_Utils;
/

CREATE OR REPLACE PACKAGE BODY Province_Utils AS
    -- Insert
    PROCEDURE insertProvince(pId NUMBER, pName VARCHAR2, pId_Country NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Province (id_Province, name, id_country)
               VALUES (s_Province.nextval, pName, pId_country);
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END insertProvince;

    -- Delete
    PROCEDURE deleteProvince(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Province
        WHERE id_Province = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END deleteProvince;
    
    -- Update
    PROCEDURE updateProvinceName (pId NUMBER, pName VARCHAR2)
    IS
        BEGIN
        UPDATE proy1.province
        SET name = pName
        WHERE id_province = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END updateProvinceName;
    
    -- Getter
    FUNCTION getProvinceName (pId NUMBER) RETURN VARCHAR2
    IS
        vName VARCHAR(20);
    BEGIN
        SELECT name INTO vName
        FROM province
        WHERE id_province = pId;
        RETURN vName;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getProvinceName;
    
END Province_Utils;
