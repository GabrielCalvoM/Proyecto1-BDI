CREATE OR REPLACE TRIGGER proy1.beforeInsertCanton
BEFORE INSERT
ON proy1.Canton
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCanton;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateCanton
BEFORE UPDATE
ON proy1.Canton
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateCanton;