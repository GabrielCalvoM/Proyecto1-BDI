CREATE TABLE Movie (
    id_movie    NUMBER(8),
    name_movie  VARCHAR(70)  CONSTRAINT movie_name_nn NOT NULL,
    id_product  NUMBER(8)    CONSTRAINT movie_idProduct_nn NOT NULL
);

CREATE SEQUENCE s_movie
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE Movie
    ADD
    CONSTRAINT pk_movie PRIMARY KEY (id_movie)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Movie
    ADD
    CONSTRAINT fk_movie_product FOREIGN KEY (id_product) REFERENCES Product(id_product);