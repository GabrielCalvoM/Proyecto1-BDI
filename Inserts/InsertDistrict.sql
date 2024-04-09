DELETE FROM district;

INSERT INTO district VALUES (s_district.NEXTVAL, 'Guadalupe', 1);
INSERT INTO district VALUES (s_district.NEXTVAL, 'La Trinidad', 2);
INSERT INTO district VALUES (s_district.NEXTVAL, 'Guadalupita', 3);
INSERT INTO district VALUES (s_district.NEXTVAL, 'Shinagawa', 5);
INSERT INTO district VALUES (s_district.NEXTVAL, 'Barranco', 6);

DROP SEQUENCE s_district;

CREATE SEQUENCE s_district
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;
    
SELECT s_district.NEXTVAL FROM dual;

SELECT d.id_district, d.name, c.name
    FROM district d
    INNER JOIN canton c
    ON d.id_canton = c.id_canton;