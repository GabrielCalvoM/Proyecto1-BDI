CREATE TABLE Actor (
    id_actor   NUMBER(8)
);

ALTER TABLE actor
    ADD
    CONSTRAINT pk_actor PRIMARY KEY (id_actor)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE actor
    ADD
    CONSTRAINT fk_actor_artist FOREIGN KEY (id_actor) REFERENCES Artist(id_artist);