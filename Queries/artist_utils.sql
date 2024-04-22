CREATE OR REPLACE PACKAGE artist_Utils IS
    -- Insert
    PROCEDURE insertArtist(pId NUMBER, pId_type NUMBER, pBiography VARCHAR2, pTrivia VARCHAR2);
    -- Delete
    PROCEDURE deleteArtist(pId NUMBER);
    -- Update
    PROCEDURE updateArtist(pId NUMBER, pId_type NUMBER, pBiography VARCHAR2, pTrivia VARCHAR2);
    --Gets
    PROCEDURE getArtistsOfType(pId_type NUMBER, artistCursor OUT SYS_REFCURSOR);
    
    PROCEDURE getArtistTypes(artistCursor OUT SYS_REFCURSOR);
    
    FUNCTION getTypeOfArtist(pId NUMBER) RETURN NUMBER;
    
    PROCEDURE getArtist(pId NUMBER, pFirst_name OUT VARCHAR2, pLast_name OUT VARCHAR2, 
    pArtistType OUT VARCHAR2, pArtistTypeId OUT NUMBER, pBiography OUT VARCHAR2, pTrivia OUT VARCHAR2,
    pDate OUT VARCHAR2, pHeight OUT NUMBER);
END artist_Utils;

CREATE OR REPLACE PACKAGE BODY Artist_Utils AS
--Insert
    PROCEDURE insertArtist(pId NUMBER, pId_type NUMBER, pBiography VARCHAR2, pTrivia VARCHAR2)
    IS
    BEGIN
        INSERT INTO Artist
        VALUES (pId, pId_type, pBiography, pTrivia);
        COMMIT;
        
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line('[ERROR] Unexpected Error, please try again.');

    END insertArtist;
    
    PROCEDURE deleteArtist(pId NUMBER)
    IS
    BEGIN
        DELETE FROM Artist
        WHERE pID = id_artist;
        DELETE FROM Person
        WHERE pID = id_person;
        COMMIT;
        
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
        
    END deleteArtist;
    
    PROCEDURE updateArtist(pId NUMBER, pId_type NUMBER, pBiography VARCHAR2, pTrivia VARCHAR2)
    IS
    BEGIN
        UPDATE Artist
        SET id_artistType = pId_Type, biography_artist = pBiography, trivia_data = pTrivia
        WHERE id_artist = pId;
        
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
                
    END updateArtist;
    
    PROCEDURE getArtistsOfType(pId_type NUMBER, artistCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN artistCursor
        FOR
        SELECT a.id_artist, p.first_name, p.last_name
        FROM Artist a
        JOIN Person p
        ON a.id_artist = p.id_person
        WHERE id_artistType = pId_type;
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getArtistsOfType;
    
    PROCEDURE getArtistTypes(artistCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN artistCursor
        FOR
        SELECT id_artistType, name_type
        FROM ArtistType;
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getArtistTypes;
    
    FUNCTION getTypeOfArtist(pId NUMBER) RETURN NUMBER
    IS
        vIdType NUMBER;
    BEGIN
        SELECT id_artisttype INTO vIdType
        FROM Artist
        WHERE id_artist = pId;
        RETURN vIdType;
    END getTypeOfArtist;
    
    PROCEDURE getArtist(pId NUMBER, pFirst_name OUT VARCHAR2, pLast_name OUT VARCHAR2, 
    pArtistType OUT VARCHAR2, pArtistTypeId OUT NUMBER, pBiography OUT VARCHAR2, pTrivia OUT VARCHAR2,
    pDate OUT VARCHAR2, pHeight OUT NUMBER)
    IS
    BEGIN
        SELECT p.first_name, p.last_name, t.name_type, a.id_artisttype, a.biography_artist, a.trivia_data, 
        p.birth_date, p.height_artist
        INTO pFirst_name, pLast_name, pArtistType, pArtistTypeId, pBiography, pTrivia, pDate, pHeight
        FROM Artist a
        JOIN Person p ON a.id_artist = p.id_person
        JOIN ArtistType t ON a.id_artisttype = t.id_artisttype
        WHERE a.id_artist = pId;
    END getArtist;

END Artist_Utils;