CREATE OR REPLACE TRIGGER proy1.beforeInsertRelativeType
BEFORE INSERT
ON proy1.RelativeType
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertRelativeType;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateRelativeType
BEFORE UPDATE
ON proy1.RelativeType
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateRelativeType;