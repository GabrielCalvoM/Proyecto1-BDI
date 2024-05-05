create or replace PACKAGE ViewedProduct_Utils IS
    -- Insert
    PROCEDURE insertViewedProduct(pId_User NUMBER, pId_Product NUMBER);
    -- Delete
    PROCEDURE deleteViewedProduct(pId_User NUMBER, pId_product NUMBER);

    PROCEDURE getViewedProducts(pId_User NUMBER, productsCursor OUT SYS_REFCURSOR);
END ViewedProduct_Utils;

create or replace PACKAGE BODY ViewedProduct_Utils AS
    PROCEDURE insertViewedProduct(pId_User NUMBER, pId_Product NUMBER)
    IS
    BEGIN
        viewedProduct_utils.deleteViewedProduct(pId_User, pId_Product);
        INSERT INTO proy1.ViewedProduct (id_viewedProduct, id_product, id_user)
        VALUES (s_viewedProduct.nextval, pId_Product, pId_User);
        COMMIT;
    END insertViewedProduct;
    
    PROCEDURE deleteViewedProduct(pId_User NUMBER, pId_product NUMBER)
    IS
    BEGIN
        DELETE FROM ViewedProduct
        WHERE id_product = pId_product AND
        id_user = pId_User;
        COMMIT;
    END deleteViewedProduct;
    
    PROCEDURE getViewedProducts(pId_User NUMBER, productsCursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN productsCursor
        FOR
        SELECT pr.id_product
        FROM ViewedProduct vp
        JOIN Product pr
        ON pr.id_product = vp.id_product
        WHERE vp.id_user = pId_user
        ORDER BY vp.id_viewedProduct DESC;
    END getViewedProducts;
        
END ViewedProduct_Utils;
