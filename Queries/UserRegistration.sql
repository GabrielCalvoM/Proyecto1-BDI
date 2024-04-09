CREATE OR REPLACE PACKAGE userRegistration IS
    PROCEDURE createUser (pFirstName VARCHAR2, pLastName VARCHAR2, pBirthDate VARCHAR2,
                          pGender VARCHAR2
    FUNCTION getAccount (pUsername VARCHAR2);