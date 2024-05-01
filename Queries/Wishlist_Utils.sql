create or replace PACKAGE Wishlist_Utils IS
    -- Insert
    PROCEDURE insertWishlist(pId_User NUMBER);
    -- Delete
    PROCEDURE deleteWishlist(pId NUMBER);
    -- Get
    FUNCTION getWishlistId(pId_User NUMBER) RETURN NUMBER;
END Wishlist_Utils;


create or replace PACKAGE BODY Wishlist_Utils AS
    -- Insert
    PROCEDURE insertWishlist(pId_User NUMBER)
    IS
    BEGIN
        INSERT INTO proy1.Wishlist (id_Wishlist, id_User)
               VALUES (s_Wishlist.nextval, pId_User);
        COMMIT;
    END insertWishlist;

    -- Delete
    PROCEDURE deleteWishlist(pId NUMBER)
    IS
    BEGIN
        DELETE FROM proy1.Wishlist
        WHERE id_Wishlist = pId;
        COMMIT;
    END deleteWishlist;

    FUNCTION getWishlistId(pId_User NUMBER) 
    RETURN NUMBER
    IS
        vId_wishlist NUMBER;
    BEGIN
        SELECT id_wishlist INTO vId_wishlist
        FROM Wishlist
        WHERE id_user = pId_User;
        RETURN vId_wishlist;
    END getWishlistId;

END Wishlist_Utils;
