CREATE TABLE wishlist (
    id_wishlist      INT AUTO_INCREMENT,
    id_user          INT NOT NULL,
    CONSTRAINT wishlist_idUser_nn CHECK (id_user IS NOT NULL),
    PRIMARY KEY (id_wishlist)
);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);
