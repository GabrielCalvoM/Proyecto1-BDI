DELETE FROM sysUser;

INSERT INTO sysUser VALUES (1, 'pmartinez@gmail.com', 80340286, 3, 1, 198765634);
INSERT INTO sysUser VALUES (2, 'srojas@gmail.com', 94056934, 1, 1, 278564253);
INSERT INTO sysUser VALUES (4, 'bcañas@gmail.com', 45687523, 1, 2, 897867465);
INSERT INTO sysUser VALUES (5, 'svela@gmail.com', 80340286, 2, 1, 278674877);
INSERT INTO sysUser VALUES (8, 'lsaura@gmail.com', 54685231, 4, 1);
INSERT INTO sysUser VALUES (10, 'ipinto@gmail.com', 45464245, 5, 2);
INSERT INTO sysUser VALUES (11, 'isobrino@gmail.com', 64856468, 3, 2);
INSERT INTO sysUser VALUES (12, 'smoya@gmail.com', 32147985, 2, 1);

SELECT p.first_name, p.last_name, u.email, u.phone_number, d.name, i.name
    FROM sysUser u
    INNER JOIN person p
    ON u.id_user = p.id_person
    INNER JOIN district d
    ON u.id_district = d.id_district
    INNER JOIN identificationType i
    ON u.id_type = i.id_type