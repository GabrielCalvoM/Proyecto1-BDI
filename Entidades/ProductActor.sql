CREATE TABLE ProductActor (
    id_productActor     NUMBER(8),
    id_product              NUMBER(8),
    id_actor            NUMBER(8)
);

CREATE SEQUENCE s_productActor
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE ProductActor
    ADD
    CONSTRAINT pk_productActor PRIMARY KEY (id_productActor)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE ProductActor
    ADD
    CONSTRAINT fk_productActor_product FOREIGN KEY (id_product) 
    REFERENCES Product(id_product);

ALTER TABLE ProductActor
    ADD
    CONSTRAINT fk_productActor_actor FOREIGN KEY (id_actor) 
    REFERENCES Actor(id_actor);