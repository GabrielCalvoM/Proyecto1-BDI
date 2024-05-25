CREATE OR REPLACE PACKAGE ArtistPhoto_Utils IS
    -- Insert
    PROCEDURE insertArtistPhoto(pIdPhoto NUMBER, pIdArtist NUMBER);
    -- Delete
    PROCEDURE deleteArtistPhoto(pIdArtist NUMBER);
    -- Get
    FUNCTION getArtistPhoto(pIdArtist NUMBER) RETURN SYS_REFCURSOR;
END ArtistPhoto_Utils;
/

CREATE OR REPLACE PACKAGE BODY ArtistPhoto_Utils AS
    -- Insert
    PROCEDURE insertArtistPhoto(pIdPhoto NUMBER, pIdArtist NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.artistPhoto (id_photo, id_artist)
               VALUES (pIdPhoto, pIdArtist);
        COMMIT;

    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');


    END insertArtistPhoto;
    
    -- Delete
    PROCEDURE deleteArtistPhoto(pIdArtist NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.artistPhoto
        WHERE id_artist = pIdArtist;

        DELETE FROM photo
        WHERE id_photo NOT IN
        (SELECT id_photo FROM ArtistPhoto);
        COMMIT;
    END deleteArtistPhoto;
    
    -- Get
    FUNCTION getArtistPhoto(pIdArtist NUMBER)
    RETURN SYS_REFCURSOR
    IS
        vCursor SYS_REFCURSOR;
    BEGIN
        OPEN vCursor
        FOR
        SELECT ph.picture
        FROM artistPhoto aph
        LEFT JOIN photo ph ON aph.id_photo = ph.id_photo
        WHERE aph.id_artist = pIdArtist;
        RETURN vCursor;
    END getArtistPhoto;
    
END ArtistPhoto_Utils;