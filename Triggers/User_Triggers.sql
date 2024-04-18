CREATE OR REPLACE TRIGGER proy1.beforeInsertSysUser
BEFORE INSERT
ON proy1.sysUser
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertSysUser;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateSysUser
BEFORE UPDATE
ON proy1.sysUser
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateSysUser;