CREATE TABLE Episode (
    id_episode      NUMBER(8),
    number_episode  NUMBER(4)       CONSTRAINT episode_number_nn NOT NULL, 
    title_episode   VARCHAR(50)     CONSTRAINT episode_title_nn NOT NULL,
    id_season       NUMBER(8)       CONSTRAINT episode_idSeason_nn NOT NULL
);

CREATE SEQUENCE s_episode
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE Episode
    ADD
    CONSTRAINT pk_episode PRIMARY KEY (id_episode)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Episode
    ADD
    CONSTRAINT fk_episode_season FOREIGN KEY (id_season) REFERENCES Season(id_season);
    
ALTER TABLE Episode
    ADD duration_episode  NUMBER(3);