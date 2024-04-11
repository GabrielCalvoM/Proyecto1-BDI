CREATE OR REPLACE TRIGGER proy1.beforeInsertActor
BEFORE INSERT
ON proy1.Actor
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertActor;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateActor
BEFORE UPDATE
ON proy1.Actor
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateActor;