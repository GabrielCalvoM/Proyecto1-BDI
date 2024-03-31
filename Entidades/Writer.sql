CREATE TABLE Writer (
    id_writer   NUMBER(8)
);

ALTER TABLE Writer
    ADD
    CONSTRAINT pk_writer PRIMARY KEY (id_writer)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Writer
    ADD
    CONSTRAINT fk_writer_artist FOREIGN KEY (id_writer) REFERENCES Artist(id_artist);