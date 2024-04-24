CREATE OR REPLACE PACKAGE ArtistType_utils IS
    PROCEDURE insertArtistType(pname_Type IN VARCHAR2);
    
    PROCEDURE setArtistType(pId IN NUMBER, pname_Type IN VARCHAR2);
    
    FUNCTION  getArtistType(pId IN NUMBER) RETURN VARCHAR2;
    
    PROCEDURE getArtistTypes(ArtistTypesCursor OUT SYS_REFCURSOR);
    
END ArtistType_utils;
/

-- Lógica de procedimientos
CREATE OR REPLACE PACKAGE BODY ArtistType_utils AS

-- Insert
    PROCEDURE insertArtistType(pname_Type IN VARCHAR2)
    IS
    
    BEGIN
        INSERT INTO ArtistType (id_ArtistType, name_Type)
            VALUES (s_ArtistType.NEXTVAL, pname_Type);
    COMMIT;

    END;

-- Setters
    PROCEDURE setArtistType(pId IN NUMBER, pname_Type IN VARCHAR2)
    IS
    
    BEGIN
        UPDATE ArtistType
        SET name_Type = pname_Type
        WHERE id_ArtistType = pId;
        COMMIT;
    
    END;

-- Getters
    FUNCTION  getArtistType(pId IN NUMBER)
    RETURN VARCHAR2
    IS
        vname_Type     VARCHAR2(20);
    
    BEGIN
        SELECT name_Type INTO vname_Type
        FROM ArtistType
        WHERE id_ArtistType = pId;
        RETURN (vname_Type);
    
    END;
    
    PROCEDURE getArtistTypes(ArtistTypesCursor OUT SYS_REFCURSOR) 
    IS
    BEGIN 
        OPEN ArtistTypesCursor
        FOR
        SELECT id_ArtistType, name_Type
        FROM ArtistType;

    END getArtistTypes;

END ArtistType_utils;