DROP TABLE priceLog;

CREATE TABLE priceLog (
    id_log              NUMBER(8),
    previous_price      NUMBER(5, 3) CONSTRAINT priceLog_previousPrice_nn NOT NULL,
    later_price         NUMBER(5, 3) CONSTRAINT priceLog_laterPrice_nn NOT NULL,
    change_date         DATE DEFAULT SYSDATE CONSTRAINT priceLog_changedate_nn NOT NULL,
    id_product          NUMBER(6) CONSTRAINT priceLog_idProduct_nn NOT NULL,
    id_streamPlatform   NUMBER(6) CONSTRAINT priceLog_idPlatform_nn NOT NULL
);

CREATE SEQUENCE s_priceLog
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000
    NOCACHE
    NOCYCLE;

ALTER TABLE priceLog
    ADD
    CONSTRAINT pk_priceLog PRIMARY KEY (id_log)
    USING INDEX
    TABLESPACE proyecto1_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 90K PCTINCREASE 0);
      
ALTER TABLE priceLog
    ADD
    CONSTRAINT fk_priceLog_product FOREIGN KEY (id_product) REFERENCES product(id_product);

ALTER TABLE priceLog 
    ADD
    CONSTRAINT fk_priceLog_streamPlatform FOREIGN KEY (id_streamPlatform) REFERENCES streamPlatform(id_streamPlatform);