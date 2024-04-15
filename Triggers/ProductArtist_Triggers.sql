CREATE OR REPLACE TRIGGER proy1.beforeInsertProductArtist
BEFORE INSERT
ON proy1.ProductArtist
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductArtist;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductArtist
BEFORE UPDATE
ON proy1.ProductArtist
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductArtist;