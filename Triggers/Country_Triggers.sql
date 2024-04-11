CREATE OR REPLACE TRIGGER proy1.beforeInsertCountry
BEFORE INSERT
ON proy1.Country
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCountry;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateCountry
BEFORE UPDATE
ON proy1.Country
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateCountry;