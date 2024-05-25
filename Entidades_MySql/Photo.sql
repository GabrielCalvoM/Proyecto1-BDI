CREATE TABLE photo (
    id_photo        INT AUTO_INCREMENT,
    picture         VARCHAR(200) NOT NULL,
    CONSTRAINT photo_picture_nn CHECK (picture IS NOT NULL),
    PRIMARY KEY (id_photo)
);
