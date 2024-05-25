-- Procedure to insert an account
DELIMITER //
CREATE PROCEDURE insertAccount(
    IN pUsername VARCHAR(20),
    IN pPassword TEXT,
    IN pId_User INT,
    IN pId_AccountType INT,
    IN pId_Catalogue INT
)
BEGIN
    INSERT INTO UserAccount (username, accountPassword, id_user, id_accountType, id_catalogue)
    VALUES (pUsername, pPassword, pId_User, pId_AccountType, pId_Catalogue);
    COMMIT;
END //
DELIMITER ;

-- Procedure to delete an account by id
DELIMITER //
CREATE PROCEDURE deleteAccount(
    IN pId INT
)
BEGIN
    DELETE FROM UserAccount
    WHERE id_account = pId;
    COMMIT;
END //
DELIMITER ;

-- Procedure to update an account
DELIMITER //
CREATE PROCEDURE updateAccount(
    IN pId INT,
    IN pUsername VARCHAR(20),
    IN pPassword TEXT,
    IN pId_User INT
)
BEGIN
    UPDATE UserAccount
    SET username = pUsername, accountPassword = pPassword, id_user = pId_user
    WHERE id_account = pId;
    COMMIT;
END //
DELIMITER ;

-- Procedure to get account details by id
DELIMITER //
CREATE PROCEDURE getAccount(
    IN pId INT,
    OUT pUsername VARCHAR(20),
    OUT pId_user INT,
    OUT pId_type INT
)
BEGIN
    SELECT username, id_user, id_accountType INTO pUsername, pId_user, pId_type
    FROM UserAccount
    WHERE id_account = pId;
END //
DELIMITER ;

-- Function to check user password
DELIMITER //
CREATE FUNCTION checkUserPassword (
    pUsername VARCHAR(20),
    pPassword TEXT
) 
RETURNS INT
READS SQL DATA
BEGIN 
    DECLARE vId INT;
    SELECT id_account INTO vId
    FROM UserAccount 
    WHERE username = pUsername AND accountPassword = pPassword;
    RETURN vId;
END //
DELIMITER ;

-- Function to check if username is unique
DELIMITER //
CREATE FUNCTION getUsernameUnique(
    pUsername VARCHAR(20)
) RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vCount INT;
    SELECT COUNT(*) INTO vCount
    FROM UserAccount
    WHERE pUsername = username;
    RETURN vCount;
END //
DELIMITER ;

-- Function to get user id by account id
DELIMITER //
CREATE FUNCTION getUserId(
    pId INT
) RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vId_user INT;
    SELECT id_user INTO vId_user
    FROM UserAccount
    WHERE pId = id_account;
    RETURN vId_user;
END //
DELIMITER ;

-- Function to get username by user id
DELIMITER //
CREATE FUNCTION getUsernameByUserId(
    pId_user INT
) RETURNS VARCHAR(20)
READS SQL DATA
BEGIN
    DECLARE vUsername VARCHAR(20);
    SELECT username INTO vUsername
    FROM UserAccount
    WHERE id_user = pId_user;
    RETURN vUsername;
END //
DELIMITER ;
