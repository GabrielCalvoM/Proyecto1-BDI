CREATE OR REPLACE TRIGGER proy1.beforeInsertPriceLog
BEFORE INSERT
ON proy1.PriceLog
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPriceLog;

CREATE OR REPLACE TRIGGER proy1.beforeUpdatePriceLog
BEFORE UPDATE
ON proy1.PriceLog
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdatePriceLog;