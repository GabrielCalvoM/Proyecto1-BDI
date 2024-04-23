CREATE OR REPLACE PACKAGE Series_Utils IS
    -- Insert
    PROCEDURE insertSeries(pId_product NUMBER);
    -- Delete
    PROCEDURE removeSeries(pId NUMBER);
    PROCEDURE getAllSeries (seriesCursor OUT SYS_REFCURSOR);
END Series_Utils;
/

CREATE OR REPLACE PACKAGE BODY Series_Utils AS
    -- Insert
    PROCEDURE insertSeries(pId_product NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Series (id_Series, id_product)
               VALUES (s_Series.nextval, pId_product);
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
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
        DELETE FROM Series
        WHERE id_series = pId;
        product_utils.removeProduct(vIdProduct);
        COMMIT;
    END removeSeries;
    
    PROCEDURE getAllSeries (seriesCursor OUT SYS_REFCURSOR)
    IS
    BEGIN 
        OPEN seriesCursor
        FOR
        SELECT s.id_series, p.title
        FROM Series s
        LEFT JOIN Product p ON s.id_product = p.id_product;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getAllSeries;
    
END Series_Utils;
