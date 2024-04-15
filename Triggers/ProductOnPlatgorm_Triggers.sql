CREATE OR REPLACE TRIGGER proy1.beforeInsertProductOnPlatform
BEFORE INSERT
ON proy1.ProductOnPlatform
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductOnPlatform;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductOnPlatform
BEFORE UPDATE
ON proy1.ProductOnPlatform
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductOnPlatform;