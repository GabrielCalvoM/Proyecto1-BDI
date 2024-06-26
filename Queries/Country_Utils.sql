CREATE OR REPLACE PACKAGE Country_Utils IS
    --get all
    PROCEDURE getCountries(countryCursor OUT SYS_REFCURSOR);
    --insert
    PROCEDURE insertCountry(pName VARCHAR);
    --delete
    PROCEDURE removeCountry(pId NUMBER);
    --get
    FUNCTION getCountryName(pId NUMBER) RETURN VARCHAR;
END Country_Utils;

CREATE OR REPLACE PACKAGE BODY Country_Utils AS
    PROCEDURE getCountries(countryCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN countryCursor
        FOR
        SELECT id_country, name
        FROM Country;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getCountries;
    
    PROCEDURE insertCountry (pName VARCHAR)
    IS
    BEGIN
        INSERT INTO COUNTRY
        VALUES(s_country.nextval, pName);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END insertCountry;
    
    PROCEDURE removeCountry(pId NUMBER)
    IS
    BEGIN
        DELETE FROM Country
        WHERE id_country = pId;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END removeCountry;
    
    FUNCTION getCountryName(pId NUMBER) RETURN VARCHAR
    IS
        vName VARCHAR(20);
    BEGIN
        SELECT name INTO vName
        FROM Country
        WHERE id_country = pId;
        RETURN vName;
        
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    END getCountryName;
END Country_Utils;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                