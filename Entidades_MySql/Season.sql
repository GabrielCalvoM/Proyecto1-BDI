CREATE TABLE Season (
    id_season       INT AUTO_INCREMENT,
    number_season   INT NOT NULL,
    id_series       INT NOT NULL,
    CONSTRAINT season_number_nn CHECK (number_season IS NOT NULL),
    CONSTRAINT season_idSeries_nn CHECK (id_series IS NOT NULL),
    PRIMARY KEY (id_season)
);

ALTER TABLE Season
    ADD CONSTRAINT fk_season_series FOREIGN KEY (id_series) REFERENCES Series(id_series);
