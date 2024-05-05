CREATE OR REPLACE PACKAGE Episode_Utils IS
    -- Insert
    PROCEDURE insertEpisode(pNumber_episode NUMBER, pTitle VARCHAR2, pId_season NUMBER,
    pDuration NUMBER);
    -- Delete
    PROCEDURE deleteEpisode(pId NUMBER);
    PROCEDURE deleteAllEpisodes(pId_season NUMBER);
END Episode_Utils;
/

CREATE OR REPLACE PACKAGE BODY Episode_Utils AS
    PROCEDURE insertEpisode(pNumber_episode NUMBER, pTitle VARCHAR2, pId_season NUMBER, pDuration NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Episode (id_episode, number_episode, title_episode, id_season, duration_episode)
               VALUES (s_episode.nextval, pNumber_episode, pTitle, pId_season, pDuration);
        COMMIT;
    END insertEpisode;
    
    PROCEDURE deleteEpisode(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Episode
        WHERE id_episode = pId;
        COMMIT;
    END deleteEpisode;
    
    PROCEDURE deleteAllEpisodes(pId_season NUMBER)
    IS
    BEGIN
        DELETE FROM Episode
        WHERE id_season = pId_season;
        COMMIT;
    END deleteAllEpisodes;
    
END Episode_Utils;