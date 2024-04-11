CREATE OR REPLACE TRIGGER proy1.beforeInsertCatalogue
BEFORE INSERT
ON proy1.Catalogue
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCatalogue;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateCatalogue
BEFORE UPDATE
ON proy1.Catalogue
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateCatalogue;