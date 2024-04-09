DELETE FROM productCategory;

INSERT INTO productCategory VALUES (s_productCategory.NEXTVAL, 1, 1);
INSERT INTO productCategory VALUES (s_productCategory.NEXTVAL, 1, 2);
INSERT INTO productCategory VALUES (s_productCategory.NEXTVAL, 1, 3);

DROP SEQUENCE s_productCategory;

CREATE SEQUENCE s_productCategory
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;
    
SELECT s_productCategory.NEXTVAL FROM dual;

SELECT r.id_productCategory, p.title, c.name
    FROM productCategory r
    INNER JOIN product p
    ON r.id_product = p.id_product
    INNER JOIN category c
    ON r.id_category = c.id_category