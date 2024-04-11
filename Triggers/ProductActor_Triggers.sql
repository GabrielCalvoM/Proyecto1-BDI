CREATE OR REPLACE TRIGGER proy1.beforeInsertProductActor
BEFORE INSERT
ON proy1.ProductActor
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductActor;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductActor
BEFORE UPDATE
ON proy1.ProductActor
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductActor;