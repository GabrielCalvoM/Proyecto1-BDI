CREATE OR REPLACE TRIGGER proy1.beforeInsertProductWriter
BEFORE INSERT
ON proy1.ProductWriter
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductWriter;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductWriter
BEFORE UPDATE
ON proy1.ProductWriter
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductWriter;