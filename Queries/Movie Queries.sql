CREATE OR REPLACE PACKAGE movie_utils IS
    PROCEDURE insertMovie(pTitle IN VARCHAR2, pYear IN NUMBER,
                          pDuration IN TIMESTAMP, pSynopsis IN VARCHAR2,
                          pTrailer IN VARCHAR2);

END movie_utils;
/

-- Lógica de Procedimientos
CREATE OR REPLACE PACKAGE BODY movie_utils AS

-- Insert
    PROCEDURE insertMovie(pTitle IN VARCHAR2, pYear IN NUMBER,
                          pDuration IN TIMESTAMP, pSynopsis IN VARCHAR2,
                          pTrailer IN VARCHAR2)
    IS
    
    BEGIN
        product_Utils.insertProduct(pTitle, pYear, pDuration, pSynopsis,
                                   pTrailer);
        INSERT INTO movie (id_movie)
            VALUES (product_Utils.getId);
        COMMIT;
        
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Uno de los parámetros excede la longitud
                                 permitida');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Sucedió un error inesperado');
            ROLLBACK;
        
    END;

END movie_utils;