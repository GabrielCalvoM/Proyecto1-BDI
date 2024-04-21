CREATE OR REPLACE PACKAGE movie_utils IS
    PROCEDURE insertMovie(pIdProduct NUMBER, pDuration NUMBER);
    PROCEDURE removeMovie(pId NUMBER);
    PROCEDURE getAllMovies(movieCursor OUT SYS_REFCURSOR);
END movie_utils;


-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY movie_utils AS

-- Insert
    PROCEDURE insertMovie(pIdProduct NUMBER, pDuration NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Movie(id_movie, id_product, duration_movie)
        VALUES (s_movie.NEXTVAL, pIdProduct, pDuration);
        COMMIT;
        
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
        
    END insertMovie;
    
    PROCEDURE removeMovie(pId NUMBER)
    IS
        vIdProduct NUMBER;
    BEGIN
        SELECT m.id_product INTO vIdProduct
        FROM Movie m
        LEFT JOIN Product p ON m.id_product = p.id_product
        WHERE m.id_movie = pId;
        productPhoto_utils.deleteProductPhoto(vIdProduct);
        DELETE FROM Movie
        WHERE id_movie = pId;
        product_utils.removeProduct(vIdProduct);
        COMMIT;
    END removeMovie;
    
    PROCEDURE getAllMovies(movieCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN movieCursor
        FOR
        SELECT m.id_movie, p.title
        FROM Movie m
        LEFT JOIN Product p on m.id_product = p.id_product;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getAllMovies;

END movie_utils;