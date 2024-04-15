CREATE OR REPLACE TRIGGER proy1.beforeInsertProductOnCatalogue
BEFORE INSERT
ON proy1.ProductOnCatalogue
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductOnCatalogue;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductOnCatalogue
BEFORE UPDATE
ON proy1.ProductOnCatalogue
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductOnCatalogue;