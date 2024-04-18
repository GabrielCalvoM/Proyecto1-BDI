CREATE OR REPLACE TRIGGER proy1.beforeInsertWishedProduct
BEFORE INSERT
ON proy1.WishedProduct
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertWishedProduct;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateWishedProduct
BEFORE UPDATE
ON proy1.WishedProduct
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateWishedProduct;