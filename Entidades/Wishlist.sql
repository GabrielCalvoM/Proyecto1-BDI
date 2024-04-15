CREATE TABLE wishlist (
    id_wishlist      NUMBER(10),
    id_user          NUMBER(10) CONSTRAINT wishlist_idUser_nn NOT NULL
);

CREATE SEQUENCE s_wishlist
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000
    NOCACHE
    NOCYCLE;

ALTER TABLE wishlist
    ADD
    CONSTRAINT pk_wishlist PRIMARY KEY (id_wishlist)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE wishlist
    ADD
    CONSTRAINT fk_wishlist_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);