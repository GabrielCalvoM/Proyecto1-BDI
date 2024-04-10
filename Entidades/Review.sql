CREATE TABLE Review (
    id_review   NUMBER(8),
    score       NUMBER(1),
    description_review VARCHAR(3000),
    id_user     NUMBER(8),
    id_product  NUMBER(8)
);

ALTER TABLE Review
ADD CONSTRAINT review_score_limit CHECK (score >= 1 AND score <= 5);

ALTER TABLE Review
    ADD
    CONSTRAINT pk_review PRIMARY KEY (id_review)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);

ALTER TABLE Review
    ADD
    CONSTRAINT fk_review_user FOREIGN KEY (id_user)
    REFERENCES sysUser(id_user);

ALTER TABLE Review
    ADD
    CONSTRAINT fk_review_product FOREIGN KEY (id_product)
    REFERENCES Product(id_product);