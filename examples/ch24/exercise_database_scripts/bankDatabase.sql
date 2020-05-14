DROP TABLE BankDatabase;

CREATE TABLE BankDatabase
(
   AccountNumber INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   PIN INT NOT NULL,
   AvailableBalance DOUBLE NOT NULL,
   TotalBalance DOUBLE NOT NULL,
   PRIMARY KEY (AccountNumber)
) ;

