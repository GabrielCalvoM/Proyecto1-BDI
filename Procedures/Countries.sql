CREATE OR REPLACE PROCEDURE getCountries(countryCursor OUT SYS_REFCURSOR)
AS
BEGIN 
    OPEN countryCursor
    FOR
    SELECT id_country, name
    FROM Country;
END;

CREATE OR REPLACE PROCEDURE insertCountry (pName VARCHAR)
AS
BEGIN
    INSERT INTO COUNTRY
    VALUES(s_country.nextval, pName);
    COMMIT;
END insertCountry;

CREATE OR REPLACE PROCEDURE removeCountry(pId NUMBER)
AS
BEGIN
    DELETE FROM Country
    WHERE id_country = pId;
    COMMIT;
END removeCountry;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                