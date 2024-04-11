CREATE OR REPLACE TRIGGER proy1.beforeInsertPerson
BEFORE INSERT
ON proy1.Person
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPerson;

CREATE OR REPLACE TRIGGER proy1.beforeUpdatePerson
BEFORE UPDATE
ON proy1.Person
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdatePerson;