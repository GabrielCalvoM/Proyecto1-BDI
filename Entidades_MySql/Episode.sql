CREATE TABLE Episode (
    id_episode      INT AUTO_INCREMENT,
    number_episode  INT NOT NULL, 
    title_episode   VARCHAR(50) NOT NULL,
    id_season       INT NOT NULL,
    duration_episode  INT,
    CONSTRAINT episode_number_nn CHECK (number_episode IS NOT NULL),
    CONSTRAINT episode_title_nn CHECK (title_episode IS NOT NULL),
    CONSTRAINT episode_idSeason_nn CHECK (id_season IS NOT NULL),
    PRIMARY KEY (id_episode)
);

ALTER TABLE Episode
    ADD CONSTRAINT fk_episode_season FOREIGN KEY (id_season) REFERENCES Season(id_season);
