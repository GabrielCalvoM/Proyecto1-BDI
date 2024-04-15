CREATE OR REPLACE PACKAGE Season_Utils IS
    -- Insert
    PROCEDURE insertSeason(pId NUMBER, pNumber_season NUMBER, pId_series NUMBER);
    -- Delete
    PROCEDURE deleteSeason(pId NUMBER);
    -- Update
    PROCEDURE updateSeasonNumber(pId NUMBER, pNewNum NUMBER);
    -- Getter
    FUNCTION getSeasonNumber(pId NUMBER) RETURN VARCHAR2;
END Season_Utils;
/

CREATE OR REPLACE PACKAGE BODY Season_Utils AS
    -- Insert
    PROCEDURE insertSeason(pId NUMBER, pNumber_season NUMBER, pId_series NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Season (id_Season, number_season, Id_series)
               VALUES (s_Season.nextval, pnumber_season, pId_series);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertSeason;

    -- Delete
    PROCEDURE deleteSeason(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Season
        WHERE id_Season = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteSeason;
    
    -- Update
    PROCEDURE updateSeasonNumber(pId NUMBER, pNewNum NUMBER)
    IS
    BEGIN
        UPDATE proy1.Season
        SET number_season = pNewNum
        WHERE id_Season = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END updateSeasonNumber;
    
    -- Getter
    FUNCTION getSeasonNumber (pId NUMBER) RETURN VARCHAR2
    IS
        vNum VARCHAR(20);
    BEGIN
        SELECT number_season INTO vNum
        FROM season
        WHERE id_season = pId;
        RETURN 'Season ' || vNum;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getSeasonNumber;

END Season_Utils;
