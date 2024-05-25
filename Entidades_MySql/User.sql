CREATE TABLE sysUser (
    id_user         INT,
    email           VARCHAR(30) NOT NULL,
    phone_number    INT NOT NULL,
    id_country      INT NOT NULL,
    id_type         INT NOT NULL,
    identification  INT,
    CONSTRAINT sysUser_email_nn CHECK (email IS NOT NULL),
    CONSTRAINT sysUser_phoneNumber_nn CHECK (phone_number IS NOT NULL),
    CONSTRAINT sysUser_idDistrict_nn CHECK (id_country IS NOT NULL),
    CONSTRAINT sysUser_idType_nn CHECK (id_type IS NOT NULL),
    PRIMARY KEY (id_user)
);

ALTER TABLE sysUser
    ADD CONSTRAINT fk_sysUser_person FOREIGN KEY (id_user) REFERENCES person(id_person),
    ADD CONSTRAINT fk_sysUser_country FOREIGN KEY (id_country) REFERENCES country(id_country),
    ADD CONSTRAINT fk_sysUser_identificationType FOREIGN KEY (id_type) REFERENCES identificationType(id_type);
