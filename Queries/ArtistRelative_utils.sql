CREATE OR REPLACE PACKAGE ArtistRelative_Utils IS
    -- Insert
    PROCEDURE insertArtistRelative(pId_Artist NUMBER, pId_Relative NUMBER, pId_RelationType NUMBER);
    -- Delete
    PROCEDURE deleteArtistRelative(pId NUMBER);
    -- Update
    PROCEDURE updateArtistRelativeName (pId NUMBER, pId_Relation NUMBER);
    -- Getter
    FUNCTION getArtistRelativeRelation (pId NUMBER) RETURN NUMBER;

END ArtistRelative_Utils;
/

CREATE OR REPLACE PACKAGE BODY ArtistRelative_Utils AS
    -- Insert
    PROCEDURE insertArtistRelative(pId_Artist NUMBER, pId_Relative NUMBER, pId_RelationType NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.ArtistRelative (id_ArtistRelative, id_Artist, id_Relative, id_RelationType)
               VALUES (s_ArtistRelative.nextval, pId_Artist, pId_Relative, pId_RelationType);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END insertArtistRelative;

    -- Delete
    PROCEDURE deleteArtistRelative(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ArtistRelative
        WHERE id_ArtistRelative = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteArtistRelative;
    
    -- Update
    PROCEDURE updateArtistRelativeName (pId NUMBER, pId_Relation NUMBER)
    IS
        BEGIN
        UPDATE proy1.ArtistRelative
        SET id_relationType = pId_Relation
        WHERE id_ArtistRelative = pId;
        COMMIT;
    
    EXCEPTION 
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('El parametro ingeresado no es valido');
        WHEN OTHERS THEN
            dbms_output.put_line('Error inesperado');
    
    END updateArtistRelativeName;
    
    -- Getter
    FUNCTION getArtistRelativeRelation (pId NUMBER) RETURN NUMBER
    IS
        vId_Relation VARCHAR(20);
    BEGIN
        SELECT id_RelationType INTO vId_Relation
        FROM ArtistRelative
        WHERE id_ArtistRelative = pId;
        RETURN vId_Relation;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
            RETURN ' ';
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
            RETURN ' ';
    
    END getArtistRelativeRelation;

END ArtistRelative_Utils;
