CREATE OR REPLACE TRIGGER proy1.beforeInsertStreamPlatform
BEFORE INSERT
ON proy1.StreamPlatform
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertStreamPlatform;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateStreamPlatform
BEFORE UPDATE
ON proy1.StreamPlatform
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateStreamPlatform;