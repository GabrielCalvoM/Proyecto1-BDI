CREATE OR REPLACE TRIGGER proy1.beforeInsertWishlist
BEFORE INSERT
ON proy1.Wishlist
FOR EACH ROW
BEGIN
    :NEW.created_by := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertWishlist;

CREATE OR REPLACE TRIGGER proy1.beforeUpdateWishlist
BEFORE UPDATE
ON proy1.Wishlist
FOR EACH ROW
BEGIN
    :NEW.updated_by := USER;
    :NEW.update_date := SYSDATE;
END beforeUpdateWishlist;