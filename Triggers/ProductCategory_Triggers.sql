CREATE OR REPLACE TRIGGER proy1.beforeInsertProductCategory
BEFORE INSERT
ON proy1.ProductCategory
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertProductCategory;
/

CREATE OR REPLACE TRIGGER proy1.beforeUpdateProductCategory
BEFORE UPDATE
ON proy1.ProductCategory
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateProductCategory;