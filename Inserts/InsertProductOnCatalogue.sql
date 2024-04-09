DELETE FROM productOnCatalogue;

INSERT INTO productOnCatalogue VALUES(s_productOnCatalogue.NEXTVAL, 1, 1);
INSERT INTO productOnCatalogue VALUES(s_productOnCatalogue.NEXTVAL, 1, 2);

DROP SEQUENCE s_productOnCatalogue;

CREATE SEQUENCE s_productOnCatalogue
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;
    
SELECT s_productOnCatalogue.NEXTVAL FROM dual;

SELECT o.id_productOnCatalogue, p.title, c.name
    FROM productOnCatalogue o
    INNER JOIN product p
    ON o.id_product = p.id_product
    INNER JOIN catalogue c
    ON o.id_catalogue = c.id_catalogue