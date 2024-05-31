CREATE TABLE TopProductReport (
    reportDate DATE,
    id_product INT,
    averageRating DECIMAL(10, 2),
    PRIMARY KEY (reportDate, id_product)
);

ALTER TABLE TopProductReport
    ADD CONSTRAINT fk_topreport_product FOREIGN KEY (id_product) REFERENCES Product(id_product);

DELIMITER //
CREATE PROCEDURE generateTopProductReport()
BEGIN
    DELETE FROM TopProductReport WHERE reportDate = curdate();

    INSERT INTO TopProductReport (reportDate, id_product, averageRating)
    SELECT 
        curdate() AS reportDate,
        id_product,
        getAverageRating(Product.id_product) AS averageRating
    FROM 
        Product
    ORDER BY 
        averageRating DESC
    LIMIT 10;
END //
DELIMITER ;

CALL generateTopProductReport();

DROP PROCEDURE generateTopProductReport;

SET GLOBAL event_scheduler = ON;


DELIMITER //
CREATE EVENT topReportJob
ON SCHEDULE EVERY 1 DAY
STARTS '2024-05-31 00:00:00'
DO
    CALL generateTopProductReport();

//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getTopRatedDate(IN pDate DATE)
BEGIN
    SELECT 
        id_product, 
        averageRating 
    FROM 
        TopProductReport 
    WHERE 
        reportDate = pDate
	ORDER BY 
		averageRating DESC;
END //
DELIMITER ;

DROP PROCEDURE getTopRatedDAte;

ALTER EVENT topReportJob DISABLE;
DROP EVENT topReportJob;