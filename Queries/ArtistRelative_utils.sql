CREATE OR REPLACE PACKAGE ArtistRelative_Utils IS
    -- Insert
    PROCEDURE insertArtistRelative(pId_Artist NUMBER, pId_Relative NUMBER, pId_RelationType NUMBER);
    -- Delete
    PROCEDURE deleteArtistRelative(pId NUMBER);
    -- Update
    PROCEDURE updateArtistRelativeRelation (pId NUMBER, pId_Relation NUMBER);
    
    -- Getter
    FUNCTION getArtistRelativeRelation (pId NUMBER) RETURN NUMBER;
    
    /*
    PROCEDURE getArtistsRelativesOfType(pId_type NUMBER, relativeCursor OUT SYS_REFCURSOR);
    
    PROCEDURE getArtistRelativeTypes(relativeCursor OUT SYS_REFCURSOR);
    */
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
    
    END insertArtistRelative;

    -- Delete
    PROCEDURE deleteArtistRelative(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.ArtistRelative
        WHERE id_ArtistRelative = pId;
        COMMIT;
        
    END deleteArtistRelative;
    
    -- Update
    PROCEDURE updateArtistRelativeRelation (pId NUMBER, pId_Relation NUMBER)
    IS
        BEGIN
        UPDATE proy1.ArtistRelative
        SET id_relationType = pId_Relation
        WHERE id_ArtistRelative = pId;
        COMMIT;
    
    END updateArtistRelativeRelation;
    
    -- Getter
    FUNCTION getArtistRelativeRelation (pId NUMBER) RETURN NUMBER
    IS
        vId_Relation VARCHAR(20);
    BEGIN
        SELECT id_RelationType INTO vId_Relation
        FROM ArtistRelative
        WHERE id_ArtistRelative = pId;
        RETURN vId_Relation;
    
    END getArtistRelativeRelation;
    
    -- Get specific Type
    /*
    PROCEDURE getArtistRelativesOfType(pId_Type NUMBER, relativeCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN relativeCursor
        FOR
        SELECT r.id_relative, p.first_name, p.last_name
        FROM ArtistRelative r
        INNER JOIN Person p
        ON r.id_relative = p.id_person
        WHERE id_relativeType = pId_Type;
        
        EXCEPTION
            WHEN OTHERS THEN
                dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    END getArtistRelativesOfType;
    */
END ArtistRelative_Utils;
