DROP TABLE admin;
DROP TABLE worker;

CREATE TABLE admin (
   adminID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   userName varchar (20) NOT NULL,
   password varchar (30) NOT NULL,
   PRIMARY KEY (adminID)
);

CREATE TABLE worker (
   workerID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   firstName varchar (20) NOT NULL,
   lastName varchar (30) NOT NULL,
   department varchar (30) NOT NULL,
   salary numeric(6,2) NOT NULL,
   PRIMARY KEY (workerID)
);

INSERT INTO admin (userName, password)
VALUES 
   ('admin','admin'), 
   ('brad','12345'),
   ('joe','joe123'), 
   ('marry','123'),
   ('akar','123a');

INSERT INTO worker(firstName, lastName, department, salary)
VALUES 
   ('Paul','Deitel','IT', 4000.15 ), 
   ('Harvey','Deitel', 'HR', 3000.15),
   ('Abbey','Deitel', 'IT', 2152.14), 
   ('Dan','Quirk', 'Finance', 1457.89),
   ('Michael','Morgano','HR', 4444.78);
