DELIMITER //
CREATE FUNCTION insertSeason(
    pNumber_season INT,
    pId_series INT
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE vIdSeason INT;
    INSERT INTO proy1.Season (number_season, Id_series)
           VALUES (pNumber_season, pId_series);
   SELECT LAST_INSERT_ID() INTO vIdSeason;
    RETURN vIdSeason;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteSeason(
    IN pId INT
)
BEGIN
    DELETE FROM proy1.Season
    WHERE id_Season = pId;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteAllSeasons(
    IN pId_Series INT
)
BEGIN
	DECLARE vId_Season INT;
    SELECT id_season INTO vId_Season
    FROM proy1.Season;
    CALL deleteAllEpisodes(vId_Season);
    DELETE FROM proy1.Season
    WHERE id_series = pId_Series;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAllSeasons(
    IN pId_series INT
)
BEGIN
    SELECT id_season, number_season
    FROM Season
    WHERE Id_series = pId_series
    ORDER BY number_season ASC;
END//
DELIMITER ;
