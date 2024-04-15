CREATE OR REPLACE TRIGGER proy1.beforeInsertArtistType
BEFORE INSERT
ON proy1.ArtistType
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertArtistType;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateArtistType
BEFORE UPDATE
ON proy1.ArtistType
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateArtistType;