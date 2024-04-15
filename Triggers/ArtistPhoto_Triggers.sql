CREATE OR REPLACE TRIGGER proy1.beforeInsertArtistPhoto
BEFORE INSERT
ON proy1.ArtistPhoto
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertArtistPhoto;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateArtistPhoto
BEFORE UPDATE
ON proy1.ArtistPhoto
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateArtistPhoto;