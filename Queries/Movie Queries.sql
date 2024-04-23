CREATE OR REPLACE PACKAGE movie_utils IS
    PROCEDURE insertMovie(pIdProduct NUMBER, pDuration NUMBER);
    PROCEDURE removeMovie(pId NUMBER);
    PROCEDURE getAllMovies(movieCursor OUT SYS_REFCURSOR);
    PROCEDURE getNmovies(pNum NUMBER, movieCursor OUT SYS_REFCURSOR);
END movie_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY movie_utils AS

-- Insert
    PROCEDURE insertMovie(pIdProduct NUMBER, pDuration NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Movie(id_movie, id_product, duration_movie)
        VALUES (pIdProduct, pIdProduct, pDuration);
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
        productArtist_utils.deleteArtistsForProduct(vIdProduct);
        product_utils.removeProduct(vIdProduct);
        COMMIT;
    END removeMovie;
    
    PROCEDURE getAllMovies(movieCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN movieCursor
        FOR
        SELECT m.id_movie, p.title, m.id_product
        FROM Movie m
        LEFT JOIN Product p ON m.id_product = p.id_product;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getAllMovies;
    
    PROCEDURE getNmovies(pNum NUMBER, movieCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN movieCursor
        FOR
        SELECT title, id_movie, id_product
        FROM(
        SELECT p.title, m.id_movie, m.id_product
        FROM Movie m
        LEFT JOIN Product p ON m.id_product = p.id_product)
        WHERE ROWNUM <= pNum;
    END getNmovies;

END movie_utils;