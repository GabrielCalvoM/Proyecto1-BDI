CREATE OR REPLACE TRIGGER proy1.beforeInsertArtistRelative
BEFORE INSERT
ON proy1.ArtistRelative
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertArtistRelative;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateArtistRelative
BEFORE UPDATE
ON proy1.ArtistRelative
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateArtistRelative;