DELETE FROM catalogue;

INSERT INTO catalogue VALUES (s_catalogue.NEXTVAL, 'MetaCritics');
INSERT INTO catalogue VALUES (s_catalogue.NEXTVAL, 'PandaFilms');

DROP SEQUENCE s_catalogue;

CREATE SEQUENCE s_catalogue
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000
    NOCACHE
    NOCYCLE;
    
SELECT s_catalogue.NEXTVAL FROM dual;

SELECT * FROM catalogue;