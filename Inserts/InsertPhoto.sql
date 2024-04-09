DELETE FROM photo;

INSERT INTO photo VALUES (s_photo.NEXTVAL, BFILENAME('DIR_PRODUCTPHOTOS', 'Sin t�tulo-1.png'));

DROP SEQUENCE s_photo;

CREATE SEQUENCE s_photo
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 8000000000
    NOCACHE
    NOCYCLE;
    
SELECT s_photo.NEXTVAL FROM dual;

SELECT * FROM photo;