CREATE OR REPLACE PACKAGE Season_Utils IS
    -- Insert
    FUNCTION insertSeason(pNumber_season NUMBER, pId_series NUMBER) RETURN NUMBER;
    -- Delete
    PROCEDURE deleteSeason(pId NUMBER);
    PROCEDURE deleteAllSeasons(pId_series NUMBER);
    -- Update
    PROCEDURE updateSeasonNumber(pId NUMBER, pNewNum NUMBER);
    -- Getter
    FUNCTION getSeasonNumber(pId NUMBER) RETURN VARCHAR2;
END Season_Utils;

CREATE OR REPLACE PACKAGE BODY Season_Utils AS
    -- Insert
    FUNCTION insertSeason(pNumber_season NUMBER, pId_series NUMBER)
    RETURN NUMBER
    IS
        vIdSeason NUMBER;
    BEGIN
        SELECT s_Season.nextval INTO vIdSeason FROM DUAL;
        INSERT INTO proy1.Season (id_season, number_season, Id_series)
               VALUES (vIdSeason, pnumber_season, pId_series);
        COMMIT;
        RETURN vIdSeason;
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
    
    PROCEDURE deleteAllSeasons(pId_series NUMBER)
    IS
    BEGIN
        FOR s IN (
            SELECT id_season FROM SEASON
            WHERE id_series = pId_series)
            LOOP
            episode_utils.deleteAllEpisodes(s.id_season);
        END LOOP;
        
        DELETE FROM Season
        WHERE id_series = pId_series;
        COMMIT;
    END deleteAllSeasons;
    
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
    
    END getSeasonNumber;

END Season_Utils;
