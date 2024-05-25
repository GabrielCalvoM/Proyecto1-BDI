CREATE TABLE userAccount (
    id_account      INT AUTO_INCREMENT,
    username        VARCHAR(20) NOT NULL,
    accountPassword VARCHAR(150) NOT NULL,
    id_user         INT NOT NULL,
    id_accountType  INT NOT NULL,
    id_catalogue    INT NOT NULL,
    CONSTRAINT userAccount_username_nn CHECK (username IS NOT NULL),
    CONSTRAINT uk_userAccount_username UNIQUE (username),
    CONSTRAINT userAccount_accountPassword_nn CHECK (accountPassword IS NOT NULL),
    CONSTRAINT userAccount_idUser_nn CHECK (id_user IS NOT NULL),
    CONSTRAINT userAccount_idAccountType_nn CHECK (id_accountType IS NOT NULL),
    CONSTRAINT userAccount_idCatalogue_nn CHECK (id_catalogue IS NOT NULL),
    PRIMARY KEY (id_account)
);

ALTER TABLE userAccount
    ADD CONSTRAINT fk_userAccount_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user),
    ADD CONSTRAINT fk_userAccount_accountType FOREIGN KEY (id_accountType) REFERENCES accountType(id_accountType),
    ADD CONSTRAINT fk_userAccount_catalogue FOREIGN KEY (id_catalogue) REFERENCES catalogue(id_catalogue);
