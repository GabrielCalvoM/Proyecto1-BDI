CREATE OR REPLACE TRIGGER proy1.beforeInsertProduct
BEFORE INSERT
ON proy1.Product
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProduct;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProduct
BEFORE UPDATE
ON proy1.Product
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProduct;