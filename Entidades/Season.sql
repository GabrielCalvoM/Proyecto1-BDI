CREATE TABLE Season (
    id_season   NUMBER(8),
    number_season   NUMBER(3),
    id_series   NUMBER(8)
);

CREATE SEQUENCE s_season
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE Season
    ADD
    CONSTRAINT pk_season PRIMARY KEY (id_season)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Season
    ADD
    CONSTRAINT fk_season_series FOREIGN KEY (id_series) REFERENCES Series(id_series);