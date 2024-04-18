CREATE OR REPLACE TRIGGER proy1.beforeInsertEpisode
BEFORE INSERT
ON proy1.Episode
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertEpisode;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateEpisode
BEFORE UPDATE
ON proy1.Episode
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateEpisode;