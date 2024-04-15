CREATE OR REPLACE TRIGGER proy1.beforeInsertMovie
BEFORE INSERT
ON proy1.Movie
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertMovie;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateMovie
BEFORE UPDATE
ON proy1.Movie
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateMovie;