ALTER TABLE ArtistRelative
    ADD (
        created_by      VARCHAR2(25),
        creation_date   DATE DEFAULT SYSDATE,   
        updated_by      VARCHAR(25),
        update_date     DATE DEFAULT SYSDATE
    );