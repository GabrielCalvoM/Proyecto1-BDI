DELETE FROM nationality;

INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 1, 2);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 1, 4);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 2, 1);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 3, 5);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 4, 1);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 5, 1);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 6, 1);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 6, 3);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 7, 3);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 8, 4);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 9, 6);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 9, 1);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 10, 6);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 11, 2);
INSERT INTO nationality VALUES (s_nationality.NEXTVAL, 12, 1);

DROP SEQUENCE s_nationality;

CREATE SEQUENCE s_nationality
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;
    
SELECT s_nationality.NEXTVAL FROM dual;

SELECT n.id_nationality, p.first_name, p.last_name, c.name
    FROM nationality n
    INNER JOIN person p
    ON n.id_person = p.id_person
    INNER JOIN country c
    ON n.id_country = c.id_country