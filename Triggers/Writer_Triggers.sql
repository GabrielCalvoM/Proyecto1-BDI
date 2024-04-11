CREATE OR REPLACE TRIGGER proy1.beforeInsertWriter
BEFORE INSERT
ON proy1.Writer
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertWriter;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateWriter
BEFORE UPDATE
ON proy1.Writer
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateWriter;