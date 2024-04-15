CREATE OR REPLACE TRIGGER proy1.beforeInsertNationality
BEFORE INSERT
ON proy1.Nationality
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertNationality;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateNationality
BEFORE UPDATE
ON proy1.Nationality
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateNationality;