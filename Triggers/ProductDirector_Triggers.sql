CREATE OR REPLACE TRIGGER proy1.beforeInsertProductDirector
BEFORE INSERT
ON proy1.ProductDirector
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductDirector;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductDirector
BEFORE UPDATE
ON proy1.ProductDirector
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductDirector;