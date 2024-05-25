DELIMITER //
CREATE PROCEDURE insertCategory(IN pName VARCHAR(16))
BEGIN
    INSERT INTO category (name)
    VALUES (pName);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteCategory(IN pId INT)
BEGIN
    DELETE FROM category
    WHERE id_category = pId;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getCategory(pId INT) RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE vName VARCHAR(255);
    
    SELECT name INTO vName
    FROM category
    WHERE id_category = pId;
    
    RETURN vName;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllCategories()
BEGIN 
    SELECT id_category, name
    FROM Category;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateCategory(IN pId INT, IN pName VARCHAR(255))
BEGIN
    UPDATE category
    SET name = pName
    WHERE id_category = pId;
END //
DELIMITER ;
