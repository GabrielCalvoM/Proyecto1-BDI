CREATE OR REPLACE TRIGGER proy1.beforeInsertProductPhoto
BEFORE INSERT
ON proy1.ProductPhoto
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductPhoto;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductPhoto
BEFORE UPDATE
ON proy1.ProductPhoto
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductPhoto;