CREATE TABLE userAccount (
    id_account      NUMBER(10),
    username        VARCHAR2(20) CONSTRAINT userAccount_username_nn NOT NULL,
                                 CONSTRAINT uk_userAccount_username UNIQUE (username),
    accountPassword VARCHAR2(20) CONSTRAINT userAccount_accountPassword_nn NOT NULL,
    id_user         NUMBER(10) CONSTRAINT userAccount_idUser_nn NOT NULL,
    id_accountType  NUMBER(10) CONSTRAINT userAccount_idAccountType_nn NOT NULL,
    id_catalogue    NUMBER(10) CONSTRAINT userAccount_idCatalogue_nn NOT NULL
);

CREATE SEQUENCE s_userAccount
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;

ALTER TABLE userAccount
    ADD
    CONSTRAINT pk_userAccount PRIMARY KEY (id_account)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE userAccount
    ADD
    CONSTRAINT fk_userAccount_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user);
    
ALTER TABLE userAccount
    ADD
    CONSTRAINT fk_userAccount_accountType FOREIGN KEY (id_accountType) REFERENCES accountType(id_accountType);
    
--ALTER TABLE userAccount
--    ADD
--    CONSTRAINT fk_userAccount_catalogue FOREIGN KEY (id_catalogue) REFERENCES catalogue(id_catalogue);