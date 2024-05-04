CREATE OR REPLACE PACKAGE Series_Utils IS
    -- Insert
    FUNCTION insertSeries(pId_product NUMBER) RETURN NUMBER;
    -- Delete
    PROCEDURE removeSeries(pId NUMBER);
    PROCEDURE getAllSeries (seriesCursor OUT SYS_REFCURSOR);
    PROCEDURE getNseries(pNum NUMBER, seriesCursor OUT SYS_REFCURSOR);
END Series_Utils;

CREATE OR REPLACE PACKAGE BODY Series_Utils AS
    -- Insert
    FUNCTION insertSeries(pId_product NUMBER)
    RETURN NUMBER
    IS
        vId_series NUMBER;
    BEGIN
        SELECT s_Season.nextval INTO vId_series FROM DUAL;
        INSERT INTO proy1.Series (id_Series, id_product)
               VALUES (vId_series, pId_product);
        COMMIT;
        RETURN vId_Series;
    END insertSeries;

    -- Delete
    PROCEDURE removeSeries(pId NUMBER)
    IS
        vIdProduct NUMBER;
    BEGIN
        SELECT s.id_product INTO vIdProduct
        FROM Series s
        LEFT JOIN Product p ON s.id_product = p.id_product
        WHERE s.id_series = pId;
        productPhoto_utils.deleteProductPhoto(vIdProduct);
        season_utils.deleteAllSeasons(pId);
        DELETE FROM Series
        WHERE id_series = pId;
        productArtist_utils.deleteArtistsForProduct(vIdProduct);
        product_utils.removeProduct(vIdProduct);
        COMMIT;
    END removeSeries;
    
    PROCEDURE getAllSeries (seriesCursor OUT SYS_REFCURSOR)
    IS
    BEGIN 
        OPEN seriesCursor
        FOR
        SELECT s.id_series, p.title, s.id_product
        FROM Series s
        LEFT JOIN Product p ON s.id_product = p.id_product;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getAllSeries;
    
    PROCEDURE getNseries(pNum NUMBER, seriesCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN seriesCursor
        FOR
        SELECT title, id_series, id_product
        FROM(
        SELECT p.title, s.id_series, s.id_product
        FROM Series s
        LEFT JOIN Product p ON s.id_product = p.id_product)
        WHERE ROWNUM <= pNum;
    END getNseries;
    
END Series_Utils;
