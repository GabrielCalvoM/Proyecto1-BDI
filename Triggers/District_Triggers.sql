CREATE OR REPLACE TRIGGER proy1.beforeInsertDistrict
BEFORE INSERT
ON proy1.District
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertDistrict;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateDistrict
BEFORE UPDATE
ON proy1.District
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateDistrict;