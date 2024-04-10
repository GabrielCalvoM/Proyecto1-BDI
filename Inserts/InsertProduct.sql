DELETE FROM product;

INSERT INTO product VALUES (s_product.NEXTVAL, 'Iron-Man', 2008, to_timestamp('01-01-0001 02:06:00', 'dd-mm-yyyy hh:mi:ss'), ':v', UTL_URL.ESCAPE('https://www.youtube.com/watch?v=8ugaeA-nMTc'));

DROP SEQUENCE s_product;

CREATE SEQUENCE s_product
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;
    
SELECT s_product.NEXTVAL FROM dual;

SELECT id_product, title, premiere_year, film_duration, synopsis, trailer FROM product;