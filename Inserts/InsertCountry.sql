INSERT INTO country VALUES (s_country.NEXTVAL, 'Costa Rica');
INSERT INTO country VALUES (s_country.NEXTVAL, 'M�xico');
INSERT INTO country VALUES (s_country.NEXTVAL, 'Estados Unidos');
INSERT INTO country VALUES (s_country.NEXTVAL, 'Jap�n');
INSERT INTO country VALUES (s_country.NEXTVAL, 'Rusia');
INSERT INTO country VALUES (s_country.NEXTVAL, 'Per�');

DROP SEQUENCE s_country;

CREATE SEQUENCE s_country
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 300
    NOCACHE
    NOCYCLE;
    
SELECT * FROM country;