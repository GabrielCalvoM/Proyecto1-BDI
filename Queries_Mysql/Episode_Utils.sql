-- Insert Episode
DELIMITER //
CREATE PROCEDURE insertEpisode(
    IN pNumber_episode INT,
    IN pTitle VARCHAR(50),
    IN pId_season INT,
    IN pDuration INT
)
BEGIN
    INSERT INTO Episode (number_episode, title_episode, id_season, duration_episode)
    VALUES (pNumber_episode, pTitle, pId_season, pDuration);
END //
DELIMITER ;

-- Delete Episode
DELIMITER //
CREATE PROCEDURE deleteEpisode(
    IN pId INT
)
BEGIN
    DELETE FROM Episode
    WHERE id_episode = pId;
END //
DELIMITER ;

-- Delete all episodes from season
DELIMITER //
CREATE PROCEDURE deleteAllEpisodes(
    IN pId_season INT
)
BEGIN
    DELETE FROM Episode
    WHERE id_season = pId_season;
END //
DELIMITER ;

-- Get all episodes from season
DELIMITER //
CREATE PROCEDURE getAllEpisodes(
    IN pId_season INT
)
BEGIN
    SELECT id_episode, title_episode, duration_episode
    FROM Episode
    WHERE id_season = pId_season
    ORDER BY number_episode ASC;
END //
DELIMITER ;
