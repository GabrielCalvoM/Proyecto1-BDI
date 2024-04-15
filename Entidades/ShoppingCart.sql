CREATE TABLE ShoppingCart (
    id_shoppingcart      NUMBER(10),
    id_user              NUMBER(10) CONSTRAINT shoppingCart_idUser_nn NOT NULL
);

CREATE SEQUENCE s_ShoppingCart
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;


ALTER TABLE shoppingCart
    ADD
    CONSTRAINT pk_shoppingCart PRIMARY KEY (id_shoppingcart)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE shoppingCart
    ADD
    CONSTRAINT fk_shoppingCart_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);