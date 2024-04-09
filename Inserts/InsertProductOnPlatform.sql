DELETE FROM productOnPlatform;

INSERT INTO productOnPlatform VALUES (s_productOnPlatform.NEXTVAL, 19.99, 1, 1);
INSERT INTO productOnPlatform VALUES (s_productOnPlatform.NEXTVAL, 9.99, 1, 2);

DROP SEQUENCE s_productOnPlatform;

CREATE SEQUENCE s_productOnPlatform
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000
    NOCACHE
    NOCYCLE;
    
SELECT s_productOnPlatform.NEXTVAL FROM dual;

SELECT o.id_productOnPlatform, o.price, p.title, s.name
    FROM productOnPlatform o
    INNER JOIN product p
    ON o.id_product = p.id_product
    INNER JOIN streamPlatform s
    ON o.id_streamPlatform = s.id_streamPlatform;