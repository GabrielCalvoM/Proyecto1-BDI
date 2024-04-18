-- DROP TABLE movie;
-- DROP SEQUENCE s_movie;
CREATE TABLE Movie (
    id_movie    NUMBER(6)
);

ALTER TABLE Movie
    ADD
    CONSTRAINT pk_movie PRIMARY KEY (id_movie)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Movie
    ADD
    CONSTRAINT fk_movie_product FOREIGN KEY (id_movie) REFERENCES Product(id_product);