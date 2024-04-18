CREATE OR REPLACE TRIGGER proy1.beforeInsertAccount
BEFORE INSERT
ON proy1.userAccount
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertAccount;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateAccount
BEFORE UPDATE
ON proy1.userAccount
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateAccount;
