DROP TABLE PhoneBook;

CREATE TABLE PhoneBook
(
	FirstName VARCHAR (50) NOT NULL,
	LastName VARCHAR (50) NOT NULL,
	PhoneNumber VARCHAR (50) NOT NULL
);

INSERT INTO PhoneBook (FirstName,LastName,PhoneNumber)
	VALUES ('Bob', 'Green', '5555551111'),
	       ('Sue', 'Black', '5555552222'),
	       ('Liz', 'White', '5555553333'),
	       ('Paul', 'Blue', '5555554444')