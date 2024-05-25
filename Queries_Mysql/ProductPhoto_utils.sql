DELIMITER //
CREATE PROCEDURE insertProductPhoto(pId_Photo INT, pId_Product INT)
BEGIN
    INSERT INTO proy1.ProductPhoto (id_productphoto, id_product)
    VALUES (pId_Photo, pId_Product);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteProductPhoto(pIdProduct INT)
BEGIN
    DELETE FROM proy1.ProductPhoto
    WHERE id_product = pIdProduct;

    DELETE FROM Photo
    WHERE id_photo NOT IN (
        SELECT id_productPhoto FROM ProductPhoto
    );
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION getProductMainImg(pIdProduct INT) RETURNS VARCHAR(200)
READS SQL DATA
BEGIN
    DECLARE vPath VARCHAR(200);
    SELECT ph.picture INTO vPath
    FROM ProductPhoto pph
    LEFT JOIN Photo ph ON pph.id_productPhoto = ph.id_photo
    WHERE pph.id_product = pIdProduct
    LIMIT 1;
    RETURN vPath;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getProductPhotos(pIdProduct INT)
BEGIN
    SELECT ph.picture
    FROM productPhoto pph
    LEFT JOIN photo ph ON pph.id_productphoto = ph.id_photo
    WHERE pph.id_product = pIdProduct
    ORDER BY ph.id_photo ASC;
END //
DELIMITER ;
