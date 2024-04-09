DELETE FROM priceLog;

INSERT INTO priceLog (id_log, previous_price, later_price, id_product, id_streamPlatform) VALUES (s_priceLog.NEXTVAL, 29.99, 19.99, 1, 1);
INSERT INTO priceLog VALUES (s_priceLog.NEXTVAL, 14.99, 19.99, to_date('01-03-2023', 'dd-mm-yyyy'), 1, 2);
INSERT INTO priceLog (id_log, previous_price, later_price, id_product, id_streamPlatform) VALUES (s_priceLog.NEXTVAL, 19.99, 9.99, 1, 2);

DROP SEQUENCE s_priceLog;

CREATE SEQUENCE s_priceLog
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;
    
SELECT s_priceLog.NEXTVAL FROM dual;

SELECT l.id_log, l.previous_price, l.later_price, l.change_date, p.title, s.name
    FROM priceLog l
    INNER JOIN product p
    ON l.id_product = p.id_product
    INNER JOIN streamPlatform s
    ON l.id_streamPlatform = s.id_streamPlatform