CREATE TABLE sysUser (
    id_user         NUMBER(10),
    email           VARCHAR2(30) CONSTRAINT sysUser_email_nn NOT NULL,
                                 CONSTRAINT uk_sysUser_email UNIQUE (email),
    phone_number    NUMBER(8) CONSTRAINT sysUser_phoneNumber_nn NOT NULL,
    id_district     NUMBER(8) CONSTRAINT sysUser_idDistrict_nn NOT NULL,
    id_type         NUMBER(2) CONSTRAINT sysUser_idType_nn NOT NULL
);

ALTER TABLE sysUser
    ADD identification NUMBER(10);

ALTER TABLE sysUser
    ADD
    CONSTRAINT pk_sysUser PRIMARY KEY (id_user)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
    
ALTER TABLE sysUser
    ADD
    CONSTRAINT fk_sysUser_person FOREIGN KEY (id_user) REFERENCES person(id_person);
    
ALTER TABLE sysUser
    ADD
    CONSTRAINT fk_sysUser_district FOREIGN KEY (id_district) REFERENCES district(id_district);
    
ALTER TABLE sysUser
    ADD
    CONSTRAINT fk_sysUser_identificationType FOREIGN KEY (id_type) REFERENCES identificationType(id_type);