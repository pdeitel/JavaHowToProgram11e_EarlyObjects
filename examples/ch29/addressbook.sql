DROP TABLE Addresses;

CREATE TABLE Addresses
(
	AddressID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	FirstName VARCHAR (15) NOT NULL,
	LastName VARCHAR (30) NOT NULL,
	Email VARCHAR (30) NOT NULL,
	PhoneNumber VARCHAR (15) NOT NULL,
        PRIMARY KEY (AddressID)
);

INSERT INTO Addresses (FirstName,LastName,Email,PhoneNumber)
	VALUES ('Mike','Green','demo1@deitel.com','555-5555'),
	('Mary','Brown','demo2@deitel.com','555-1234');