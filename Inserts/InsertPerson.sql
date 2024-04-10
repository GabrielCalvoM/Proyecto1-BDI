DELETE FROM person;

INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Pedro', 'Martínez', to_date('10-07-2005', 'dd-mm-yyyy'), 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Sebastián', 'Rojas', to_date('16-10-2005', 'dd-mm-yyyy'), 1);
INSERT INTO person VALUES (s_person.NEXTVAL, 'María', 'Jiménez', to_date('09-04-2008', 'dd-mm-yyyy'), 156, 2);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Bonifacio', 'Cañas', to_date('30-11-2001', 'dd-mm-yyyy'), 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Sabina', 'Vela', to_date('08-10-1994', 'dd-mm-yyyy'), 2);
INSERT INTO person VALUES (s_person.NEXTVAL, 'Ester', 'Pinto', to_date('19-10-2005', 'dd-mm-yyyy'), 172, 2);
INSERT INTO person VALUES (s_person.NEXTVAL, 'Fernando', 'Delgado', to_date('27-10-2005', 'dd-mm-yyyy'), 187, 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Luis', 'Saura', to_date('13-10-2005', 'dd-mm-yyyy'), 1);
INSERT INTO person VALUES (s_person.NEXTVAL, 'Ahmed', 'Avila', to_date('05-10-2005', 'dd-mm-yyyy'), 179, 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Isidora', 'Pinto', to_date('05-10-2005', 'dd-mm-yyyy'), 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Israel', 'Sobrino', to_date('24-10-2005', 'dd-mm-yyyy'), 1);
INSERT INTO person (id_person, first_name, last_name, birth_date, id_gender) VALUES (s_person.NEXTVAL, 'Sandra', 'Moya', to_date('02-10-2005', 'dd-mm-yyyy'), 1);

DROP SEQUENCE s_person;

CREATE SEQUENCE s_person
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 8000000000
    NOCACHE
    NOCYCLE;
    
SELECT s_person.NEXTVAL FROM dual;

SELECT p.first_name, p.last_name, p.birth_date, g.name 
    FROM person p
    INNER JOIN gender g
    ON p.id_gender = g.id_gender;