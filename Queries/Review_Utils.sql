CREATE OR REPLACE PACKAGE Review_Utils IS
    -- Insert
    PROCEDURE insertReview(pScore NUMBER, pDescription VARCHAR, pId_User NUMBER, pId_Product NUMBER);
    -- Delete
    PROCEDURE deleteReview(pId NUMBER);
    -- Update
    PROCEDURE updateReview(pId NUMBER, pScore NUMBER, pDescription VARCHAR);
    -- Getter
    FUNCTION getReview(pId NUMBER) RETURN VARCHAR2;
    PROCEDURE getProductReviews(pId_Product NUMBER, reviewCursor OUT SYS_REFCURSOR);
END Review_Utils;
/

CREATE OR REPLACE PACKAGE BODY Review_Utils AS
    -- Insert
    PROCEDURE insertReview(pScore NUMBER, pDescription VARCHAR, pId_User NUMBER, pId_Product NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Review (id_Review, score, description_review, id_user, id_product)
               VALUES (s_Review.nextval, pScore, pDescription, pId_User, pId_Product);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertReview;

    -- Delete
    PROCEDURE deleteReview(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Review
        WHERE id_Review = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteReview;
    
    -- Update
    PROCEDURE updateReview(pId NUMBER, pScore NUMBER, pDescription VARCHAR)
    IS
    BEGIN
        UPDATE proy1.Review
        SET score = pScore, description_review = pDescription
        WHERE id_review = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END updateReview;
    
    -- Getter
    FUNCTION getReview (pId NUMBER) RETURN VARCHAR2
    IS
        vScore       NUMBER;
        vDescription VARCHAR(100);
    BEGIN
        SELECT score, description_review  INTO vScore, vDescription
        FROM review
        WHERE id_review = pId;
        RETURN 'SCORE: ' || vScore || ' | ' || vDescription;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getReview;
    
    PROCEDURE getProductReviews(pId_Product NUMBER, reviewCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN reviewCursor
        FOR
        SELECT id_review, score, description_review, id_user
        FROM Review
        WHERE id_product = pId_Product;
    END getProductReviews;

END Review_Utils;
