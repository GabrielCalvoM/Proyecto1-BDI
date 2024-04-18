CREATE OR REPLACE TRIGGER proy1.beforeInsertGender
BEFORE INSERT
ON proy1.Gender
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertGender;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateGender
BEFORE UPDATE
ON proy1.Gender
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateGender;