DROP TABLE Messages;

CREATE TABLE Messages
(
	MessageID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	Date VARCHAR (20) NOT NULL,
	Name VARCHAR (50) NOT NULL,
	Email VARCHAR (50) NOT NULL,
	Message LONG VARCHAR NOT NULL
);

INSERT INTO Messages (Date,Name,Email,Message)
	VALUES ('2/21/2009', 'Bob Green', 'bgreen@bug2bug.com', 'Great site!'),
	       ('2/27/2009', 'Sue Black', 'sblack@bug2bug.com', 'I love the site! Keep up the good work!'),
	       ('2/28/2009', 'Liz White', 'lwhite@bug2bug.com', 'Very useful information. Will visit again soon.'),
	       ('3/12/2009', 'Paul Blue', 'pblue@bug2bug.com', 'Great job!')
