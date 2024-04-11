CREATE OR REPLACE TRIGGER proy1.beforeInsertOwnedProduct
BEFORE INSERT
ON proy1.OwnedProduct
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertOwnedProduct;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateOwnedProduct
BEFORE UPDATE
ON proy1.OwnedProduct
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateOwnedProduct;