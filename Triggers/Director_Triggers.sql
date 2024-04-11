CREATE OR REPLACE TRIGGER proy1.beforeInsertDirector
BEFORE INSERT
ON proy1.Director
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertDirector;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateDirector
BEFORE UPDATE
ON proy1.Director
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateDirector;