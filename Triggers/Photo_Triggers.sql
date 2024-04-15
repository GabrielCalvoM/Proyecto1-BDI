CREATE OR REPLACE TRIGGER proy1.beforeInsertPhoto
BEFORE INSERT
ON proy1.Photo
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPhoto;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdatePhoto
BEFORE UPDATE
ON proy1.Photo
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdatePhoto;