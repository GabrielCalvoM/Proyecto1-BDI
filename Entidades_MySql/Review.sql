CREATE TABLE Review (
    id_review           INT AUTO_INCREMENT,
    score               INT NOT NULL,
    description_review  VARCHAR(3000),
    id_user             INT NOT NULL,
    id_product          INT NOT NULL,
    CONSTRAINT review_score_nn CHECK (score IS NOT NULL),
    CONSTRAINT review_score_limit CHECK (score >= 1 AND score <= 5),
    PRIMARY KEY (id_review)
);

ALTER TABLE Review
    ADD CONSTRAINT fk_review_user FOREIGN KEY (id_user) REFERENCES sysUser(id_user),
    ADD CONSTRAINT fk_review_product FOREIGN KEY (id_product) REFERENCES Product(id_product);
