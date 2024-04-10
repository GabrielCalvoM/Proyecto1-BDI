DELETE FROM productPhoto;

INSERT INTO productPhoto VALUES (1, 1);

SELECT p.title, i.picture
    FROM productPhoto f
    INNER JOIN product p
    ON f.id_product = p.id_product
    INNER JOIN photo i
    ON f.id_photo = i.id_photo;