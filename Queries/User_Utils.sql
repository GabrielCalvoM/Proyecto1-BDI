CREATE OR REPLACE PACKAGE SysUser_Utils IS
    -- Insert
    PROCEDURE insertSysUser(pId NUMBER, pEmail VARCHAR2, pPhone_number NUMBER, pId_country NUMBER, 
        pId_type NUMBER, pId_number NUMBER);
    -- Delete
    PROCEDURE deleteSysUser(pId NUMBER);
    -- Update
    PROCEDURE updateSysUser(pId NUMBER, pEmail VARCHAR2, pPhone_number NUMBER);
    -- Getter
    FUNCTION getSysUser(pId NUMBER) RETURN VARCHAR2;
END SysUser_Utils;
/

CREATE OR REPLACE PACKAGE BODY SysUser_Utils AS
    -- Insert
    PROCEDURE insertSysUser(pId NUMBER, pEmail VARCHAR2, pPhone_number NUMBER, pId_country NUMBER, 
        pId_type NUMBER, pId_number NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.SysUser (id_User, email, phone_number, id_country, id_type, identification)
               VALUES (pId, pEmail, pPhone_number, pId_country, pId_type, pId_number);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertSysUser;

    -- Delete
    PROCEDURE deleteSysUser(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.SysUser
        WHERE id_user = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteSysUser;
    
    -- Update
    PROCEDURE updateSysUser(pId NUMBER, pEmail VARCHAR2, pPhone_number NUMBER)
    IS
    BEGIN
        UPDATE proy1.SysUser
        SET email = pEmail, phone_number = pPhone_number
        WHERE id_user = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END updateSysUser;
    
    -- Getter
    FUNCTION getSysUser (pId NUMBER) RETURN VARCHAR2
    IS
        vPhone_Number   NUMBER;
        vEmail          VARCHAR(30);
    BEGIN
        SELECT phone_number, email  INTO vPhone_Number, vEmail
        FROM SysUser
        WHERE id_user = pId;
        RETURN 'PHONE: ' || vPhone_Number || ', E-MAIL: ' || vEmail;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getSysUser;

END SysUser_Utils;
