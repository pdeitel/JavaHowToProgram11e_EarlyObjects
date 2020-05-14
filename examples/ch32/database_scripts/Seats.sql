DROP TABLE seats;

CREATE TABLE seats
(
	number INT NOT NULL,
	location VARCHAR (10) NOT NULL,
	class VARCHAR (10) NOT NULL,
	taken INT NOT NULL,
	PRIMARY KEY (number)
);

INSERT INTO seats VALUES ( 1, 'Aisle', 'Economy', 0 );
INSERT INTO seats VALUES ( 2, 'Aisle', 'Economy', 0 );
INSERT INTO seats VALUES ( 3, 'Aisle', 'First', 0 );
INSERT INTO seats VALUES ( 4, 'Middle', 'Economy', 0 );
INSERT INTO seats VALUES ( 5, 'Middle', 'Economy', 0 );
INSERT INTO seats VALUES ( 6, 'Middle', 'First', 0 );
INSERT INTO seats VALUES ( 7, 'Window', 'Economy', 0 );
INSERT INTO seats VALUES ( 8, 'Window', 'Economy', 0 );
INSERT INTO seats VALUES ( 9, 'Window', 'First', 0 );
INSERT INTO seats VALUES ( 10, 'Window', 'First', 0 );
