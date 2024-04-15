CREATE OR REPLACE TRIGGER proy1.beforeInsertSeason
BEFORE INSERT
ON proy1.Season
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertSeason;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateSeason
BEFORE UPDATE
ON proy1.Season
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateSeason;