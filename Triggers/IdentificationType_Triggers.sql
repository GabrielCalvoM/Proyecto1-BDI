CREATE OR REPLACE TRIGGER proy1.beforeInsertIdentificationType
BEFORE INSERT
ON proy1.IdentificationType
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertIdentificationType;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateIdentificationType
BEFORE UPDATE
ON proy1.IdentificationType
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateIdentificationType;