CREATE OR REPLACE TRIGGER proy1.beforeInsertArtist
BEFORE INSERT
ON proy1.Artist
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertArtist;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateArtist
BEFORE UPDATE
ON proy1.Artist
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateArtist;