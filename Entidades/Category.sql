CREATE TABLE category (
    id_category     NUMBER(4),
    name            VARCHAR2(15) CONSTRAINT category_name_nn NOT NULL,
                                 CONSTRAINT uk_category_name UNIQUE(name)
);

CREATE SEQUENCE s_category
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000
    NOCACHE
    NOCYCLE;

ALTER TABLE category
    ADD
    CONSTRAINT pk_category PRIMARY KEY (id_category)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);