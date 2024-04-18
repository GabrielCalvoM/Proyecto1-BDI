CREATE OR REPLACE TRIGGER proy1.beforeInsertProvince
BEFORE INSERT
ON proy1.Province
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProvince;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProvince
BEFORE UPDATE
ON proy1.Province
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProvince;