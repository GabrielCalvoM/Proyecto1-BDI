CREATE TABLE ProductArtist (
    id_productArtist              NUMBER(8),
    id_product                    NUMBER(8),
    id_artist                     NUMBER(8)
);

CREATE SEQUENCE s_productArtist
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ProductArtist
    ADD
    CONSTRAINT pk_productArtist PRIMARY KEY (id_productArtist)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE ProductArtist
    ADD
    CONSTRAINT fk_productArtist_product FOREIGN KEY (id_product) 
    REFERENCES Product(id_product);

ALTER TABLE ProductArtist
    ADD
    CONSTRAINT fk_productArtist_artist FOREIGN KEY (id_artist) 
    REFERENCES Artist(id_artist);