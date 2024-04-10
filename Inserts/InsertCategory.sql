DELETE FROM category;

INSERT INTO category VALUES (s_category.NEXTVAL, 'Action');
INSERT INTO category VALUES (s_category.NEXTVAL, 'Drama');
INSERT INTO category VALUES (s_category.NEXTVAL, 'Comedy');

DROP SEQUENCE s_category;

CREATE SEQUENCE s_category
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000
    NOCACHE
    NOCYCLE;
    
SELECT s_category.NEXTVAL FROM dual;

SELECT * FROM category;