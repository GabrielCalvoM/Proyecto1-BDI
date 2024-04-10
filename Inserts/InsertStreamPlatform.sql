DELETE FROM streamPlatform;

INSERT INTO streamPlatform VALUES (s_streamPlatform.NEXTVAL, 'Netflix');
INSERT INTO streamPlatform VALUES (s_streamPlatform.NEXTVAL, 'Disney+');

DROP SEQUENCE s_streamPlatform;

CREATE SEQUENCE s_streamPlatform
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000
    NOCACHE
    NOCYCLE;
    
SELECT s_streamPlatform.NEXTVAL FROM dual;

SELECT * FROM streamPlatform;