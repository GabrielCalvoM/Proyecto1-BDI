DELIMITER //
CREATE PROCEDURE insertSysUser(IN pId INT, IN pEmail VARCHAR(255), IN pPhone_number INT, 
                                IN pId_country INT, IN pId_type INT, IN pId_number INT)
BEGIN
    INSERT INTO proy1.SysUser (id_User, email, phone_number, id_country, id_type, identification)
    VALUES (pId, pEmail, pPhone_number, pId_country, pId_type, pId_number);
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteSysUser(IN pId INT)
BEGIN
    DELETE FROM proy1.SysUser
    WHERE id_user = pId;
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateSysUser(IN pId INT, IN pEmail VARCHAR(255), IN pPhone_number INT)
BEGIN
    UPDATE proy1.SysUser
    SET email = pEmail, phone_number = pPhone_number
    WHERE id_user = pId;
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getSysUser(pId INT) RETURNS VARCHAR(255)
READS SQL DATA
BEGIN
    DECLARE vPhone_Number INT;
    DECLARE vEmail VARCHAR(255);
    SELECT phone_number, email INTO vPhone_Number, vEmail
    FROM SysUser
    WHERE id_user = pId;
    RETURN CONCAT('PHONE: ', vPhone_Number, ', E-MAIL: ', vEmail);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllUsers()
BEGIN
    SELECT p.id_person, p.first_name, p.last_name, p.birth_date, p.id_gender
    FROM sysUser u
    INNER JOIN person p ON u.id_user = p.id_person;
END //
DELIMITER ;
