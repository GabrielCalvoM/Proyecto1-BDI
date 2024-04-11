CREATE OR REPLACE TRIGGER proy1.beforeInsertSeries
BEFORE INSERT
ON proy1.Series
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertSeries;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateSeries
BEFORE UPDATE
ON proy1.Series
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateSeries;