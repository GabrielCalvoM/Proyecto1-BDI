CREATE OR REPLACE PACKAGE Wishlist_Utils IS
    -- Insert
    PROCEDURE insertWishlist(pId NUMBER, pId_User NUMBER);
    -- Delete
    PROCEDURE deleteWishlist(pId NUMBER);
END Wishlist_Utils;
/

CREATE OR REPLACE PACKAGE BODY Wishlist_Utils AS
    -- Insert
    PROCEDURE insertWishlist(pId NUMBER, pId_User NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Wishlist (id_Wishlist, id_User)
               VALUES (s_Wishlist.nextval, pId_User);
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    
    END insertWishlist;

    -- Delete
    PROCEDURE deleteWishlist(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Wishlist
        WHERE id_Wishlist = pId;
        COMMIT;
    
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            dbms_output.put_line('[ERROR] Invalid Parameters');
        WHEN OTHERS THEN
            dbms_output.put_line('[ERROR] Unexpected Error, please try again.');
    
    END deleteWishlist;

END Wishlist_Utils;
