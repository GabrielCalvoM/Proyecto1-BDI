CREATE OR REPLACE TRIGGER proy1.beforeInsertCartProduct
BEFORE INSERT
ON proy1.CartProduct
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCartProduct;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateCartProduct
BEFORE UPDATE
ON proy1.CartProduct
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateCartProduct;