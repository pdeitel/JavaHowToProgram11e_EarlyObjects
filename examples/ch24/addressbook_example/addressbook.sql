DROP TABLE Addresses;

CREATE TABLE Addresses
(
	AddressID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	FirstName VARCHAR (50) NOT NULL,
	LastName VARCHAR (50) NOT NULL,
	Email VARCHAR (254) NOT NULL,
	PhoneNumber VARCHAR (15) NOT NULL
);

INSERT INTO Addresses (FirstName,LastName,Email,PhoneNumber)
	VALUES ('Mike','Green','demo1@deitel.com','555-5555'),
	('Mary','Brown','demo2@deitel.com','555-1234');