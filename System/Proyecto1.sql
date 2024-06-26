-- Crear TableSpace y usuario

CREATE TABLESPACE proyecto1_Data
    DATAFILE 'C:\app\cahuc\oradata\LoscraDB\proyecto1_data01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512k
    MAXSIZE 200M;
       
--  Proyecto: INDEX
       
CREATE TABLESPACE proyecto1_Ind
    DATAFILE 'C:\app\cahuc\oradata\LoscraDB\proyecto1_ind01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512K
    MAXSIZE 200M;
       
CREATE USER proy1
    IDENTIFIED BY proy1
    DEFAULT TABLESPACE proyecto1_data
    QUOTA 10M ON proyecto1_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    -- PROFILE app_user
    -- PASSWORD EXPIRE;
    
ALTER USER proy1
    QUOTA 10M ON proyecto1_Ind;
   
GRANT connect TO proy1;
GRANT create session TO proy1;
GRANT create table TO proy1;
GRANT create view TO proy1;
GRANT create sequence TO proy1;
GRANT create trigger To proy1;
GRANT create procedure TO proy1;
GRANT CREATE ANY INDEX TO proy1;
GRANT CREATE PROCEDURE TO proy1;
GRANT CREATE TRIGGER TO proy1;
alter user proy1 quota unlimited on proyecto1_ind;
