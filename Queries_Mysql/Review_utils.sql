DELIMITER //
CREATE PROCEDURE insertReview(
    IN pScore INT, 
    IN pDescription VARCHAR(255), 
    IN pId_User INT, 
    IN pId_Product INT
)
BEGIN
    INSERT INTO Review (score, description_review, id_user, id_product)
    VALUES (pScore, pDescription, pId_User, pId_Product);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteReview(
    IN pId INT
)
BEGIN
    DELETE FROM Review
    WHERE id_Review = pId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateReview(
    IN pId INT, 
    IN pScore INT, 
    IN pDescription VARCHAR(255)
)
BEGIN
    UPDATE Review
    SET score = pScore, description_review = pDescription
    WHERE id_review = pId;
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProductReviews(
    IN pId_Product INT
)
BEGIN
    SELECT id_review, score, description_review, id_user
    FROM Review
    WHERE id_product = pId_Product;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getAverageRating(
    pId_Product INT
) 
RETURNS FLOAT
DETERMINISTIC
BEGIN
    DECLARE vAverage FLOAT;
    SELECT AVG(CAST(score AS FLOAT)) INTO vAverage
    FROM Review
    WHERE id_product = pId_Product;
    
    IF vAverage IS NULL THEN
        RETURN -1;
    ELSE
        RETURN vAverage;
    END IF;
END //
DELIMITER ;
