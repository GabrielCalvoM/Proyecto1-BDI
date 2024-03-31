CREATE TABLE Director (
    id_director   NUMBER(8)
);

ALTER TABLE director
    ADD
    CONSTRAINT pk_director PRIMARY KEY (id_director)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE director
    ADD
    CONSTRAINT fk_director_artist FOREIGN KEY (id_director) REFERENCES Artist(id_artist);