DELETE FROM province;

INSERT INTO province VALUES (s_province.NEXTVAL, 'San Jose', 1);
INSERT INTO province VALUES (s_province.NEXTVAL, 'CDMX', 2);
INSERT INTO province VALUES (s_province.NEXTVAL, 'Washington DC', 3);
INSERT INTO province VALUES (s_province.NEXTVAL, 'Tokyo', 4);
INSERT INTO province VALUES (s_province.NEXTVAL, 'Moscú', 5);
INSERT INTO province VALUES (s_province.NEXTVAL, 'Lima', 6);

DROP SEQUENCE s_province;

CREATE SEQUENCE s_province
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;
    
SELECT s_province.NEXTVAL FROM dual;
    
SELECT p.id_province, p.name, c.name
    FROM province p
    INNER JOIN country c
    ON p.id_country = c.id_country;