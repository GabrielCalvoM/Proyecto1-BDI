DELETE FROM userAccount;

INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'Pedro0Martinez', '90124895', 1, 1, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'Sebas09', 'Sebas09', 2, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'BonCañas89', '3FK$FAGL356', 4, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'SabinaUwU', '90124895', 5, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'MomazosLuis', 'PapuSDLG', 8, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'Luisaurio', 'Nacho Vidal', 8, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'PintoI', '00000001', 10, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'Miku1890', 'WachiWachiWa', 10, 2, 1);
INSERT INTO userAccount VALUES (s_userAccount.NEXTVAL, 'SandMoya', 'SandMoya', 12, 2, 1);

DROP SEQUENCE s_userAccount;

CREATE SEQUENCE s_userAccount
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000000000
    NOCACHE
    NOCYCLE;
    
SELECT s_userAccount.NEXTVAL FROM dual;

SELECT a.id_account, a.username, a.accountPassword, p.first_name, p.last_name, t.name, c.name
    FROM userAccount a
    INNER JOIN person p
    ON a.id_user = p.id_person
    INNER JOIN accountType t
    ON a.id_accountType = t.id_accountType
    INNER JOIN catalogue c
    ON a.id_catalogue = c.id_catalogue