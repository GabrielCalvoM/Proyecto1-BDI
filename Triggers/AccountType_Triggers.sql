CREATE OR REPLACE TRIGGER proy1.beforeInsertAccountType
BEFORE INSERT
ON proy1.AccountType
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertAccountType;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateAccountType
BEFORE UPDATE
ON proy1.AccountType
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateAccountType;