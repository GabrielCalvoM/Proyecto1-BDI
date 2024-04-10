DELETE FROM canton;

INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Goicoechea', 1);
INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Moravia', 1);
INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Xochimilco', 2);
INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Iztapalapa', 2);
INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Shinagawa', 4);
INSERT INTO canton VALUES (s_canton.NEXTVAL, 'Chosica', 6);

DROP SEQUENCE s_canton;

CREATE SEQUENCE s_canton
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;
    
SELECT s_canton.NEXTVAL FROM dual;
    
SELECT c.id_canton, c.name, p.name
    FROM canton c
    INNER JOIN province p
    ON p.id_province = c.id_province;