CREATE OR REPLACE TRIGGER proy1.beforeInsertCategory
BEFORE INSERT
ON proy1.Category
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCategory;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateCategory
BEFORE UPDATE
ON proy1.Category
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateCategory;