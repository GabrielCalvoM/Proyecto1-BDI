CREATE OR REPLACE PACKAGE Account_Utils IS
    -- Insert
    PROCEDURE insertAccount(pUsername VARCHAR2, pPassword VARCHAR2, 
    pId_User NUMBER, pId_AccountType NUMBER, pId_Catalogue NUMBER);
    -- Delete
    PROCEDURE deleteAccount(pId NUMBER);
    -- Update
    PROCEDURE updateAccount(pId NUMBER, pUsername VARCHAR2, pPassword VARCHAR2, 
    pId_User NUMBER);
    -- Getter
    PROCEDURE getAccount(pId NUMBER, pUsername OUT VARCHAR2, pId_user OUT NUMBER, pId_type OUT NUMBER);
    FUNCTION getUserId(pId NUMBER) RETURN NUMBER;
    FUNCTION checkUserPassword (pUsername VARCHAR, pPassword VARCHAR) RETURN NUMBER;
    FUNCTION getUsernameUnique(pUsername VARCHAR2) RETURN NUMBER;
END Account_Utils;
/

CREATE OR REPLACE PACKAGE BODY Account_Utils AS
    -- Insert
    PROCEDURE insertAccount(pUsername VARCHAR2, pPassword VARCHAR2, 
    pId_User NUMBER, pId_AccountType NUMBER, pId_Catalogue NUMBER)
    IS
    BEGIN
        INSERT INTO UserAccount
                VALUES (s_useraccount.nextval, pUsername, pPassword, pId_User,
                pId_AccountType, pId_Catalogue);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertAccount;

    -- Delete
    PROCEDURE deleteAccount(pId NUMBER)
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
    
    END deleteAccount;
    
    -- Update
    PROCEDURE updateAccount(pId NUMBER, pUsername VARCHAR2, pPassword VARCHAR2, 
    pId_User NUMBER)
    IS
    BEGIN
        UPDATE UserAccount
        SET username = pUsername, accountpassword = pPassword, id_user = pId_user
        WHERE id_user = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END updateAccount;
    
    -- Getter
    PROCEDURE getAccount(pId NUMBER, pUsername OUT VARCHAR2, pId_user OUT NUMBER, pId_type OUT NUMBER)
    IS
        vUsername VARCHAR2(20);
        vId_user NUMBER;
        vId_type NUMBER;
    BEGIN
        SELECT username, id_user, id_accounttype INTO pUsername, pId_user, pId_type
        FROM UserAccount
        WHERE id_account = pId;
    END getAccount;

    FUNCTION getUserId(pId NUMBER) RETURN NUMBER
    IS
        vId_user NUMBER;
    BEGIN
        SELECT id_user INTO vId_user
        FROM UserAccount
        WHERE pId = id_account;
        RETURN vId_user;
    END getUserId;
    
    FUNCTION checkUserPassword (pUsername VARCHAR, pPassword VARCHAR) 
    RETURN NUMBER
    IS
        vId NUMBER;
    BEGIN 
        SELECT id_account INTO vId
        FROM UserAccount 
        WHERE username = pUsername AND accountPassword = pPassword;
        RETURN vId;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        RETURN -1;
    
    END checkUserPassword;
    
    FUNCTION getUsernameUnique(pUsername VARCHAR2) RETURN NUMBER
    IS
        vCount NUMBER;
    BEGIN
        SELECT COUNT(*) INTO vCount
        FROM UserAccount
        WHERE pUsername = username;
        RETURN vCount;
    END getUsernameUnique;

END Account_Utils;