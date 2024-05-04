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
    PROCEDURE getAllUsers(userCursor OUT SYS_REFCURSOR); 
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
    END insertSysUser;

    -- Delete
    PROCEDURE deleteSysUser(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.SysUser
        WHERE id_user = pId;
        COMMIT;    
    END deleteSysUser;
    
    -- Update
    PROCEDURE updateSysUser(pId NUMBER, pEmail VARCHAR2, pPhone_number NUMBER)
    IS
    BEGIN
        UPDATE proy1.SysUser
        SET email = pEmail, phone_number = pPhone_number
        WHERE id_user = pId;
        COMMIT;    
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
    END getSysUser;
    
    PROCEDURE getAllUsers (userCursor OUT SYS_REFCURSOR)
    IS
    BEGIN 
        OPEN userCursor
        FOR
        SELECT p.id_person, p.first_name, p.last_name, p.birth_date, p.id_gender
        FROM sysUser u INNER JOIN person p
        ON u.id_user = p.id_person;

    END getAllUsers;
    
END SysUser_Utils;
