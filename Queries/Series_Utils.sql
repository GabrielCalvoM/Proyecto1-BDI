CREATE OR REPLACE PACKAGE Series_Utils IS
    -- Insert
    PROCEDURE insertSeries(pId NUMBER, pName VARCHAR2, pid_product NUMBER);
    -- Delete
    PROCEDURE deleteSeries(pId NUMBER);
    -- Update
    PROCEDURE updateSeriesName (pId NUMBER, pName VARCHAR2);
    -- Getter
    FUNCTION getSeriesName (pId NUMBER) RETURN VARCHAR2;
END Series_Utils;
/

CREATE OR REPLACE PACKAGE BODY Series_Utils AS
    -- Insert
    PROCEDURE insertSeries(pId NUMBER, pName VARCHAR2, pid_product NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Series (id_Series, name_series, id_product)
               VALUES (s_Series.nextval, pName, pid_product);
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END insertSeries;

    -- Delete
    PROCEDURE deleteSeries(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Series
        WHERE id_Series = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END deleteSeries;
    
    -- Update
    PROCEDURE updateSeriesName (pId NUMBER, pName VARCHAR2)
    IS
        BEGIN
        UPDATE proy1.Series
        SET name_series = pName
        WHERE id_Series = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END updateSeriesName;
    
    -- Getter
    FUNCTION getSeriesName (pId NUMBER) RETURN VARCHAR2
    IS
        vName VARCHAR(20);
    BEGIN
        SELECT name_series INTO vName
        FROM Series
        WHERE id_Series = pId;
        RETURN vName;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getSeriesName;
    
END Series_Utils;
