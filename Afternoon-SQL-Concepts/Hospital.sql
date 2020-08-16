create database HOSPITAL;
use HOSPITAL;
create table Department (
	DEP_ID int,
    DEP_NAME varchar(50) NOT NULL,
    PRIMARY KEY (DEP_ID)
);

-- ALTER TABLE Department MODIFY DEP_NAME VARCHAR(50) NOT NULL;
-- ALTER TABLE Department ADD FOREIGN KEY (DOC_ID) REFERENCES Doctor(DOC_ID);

create Table Patient ( 
	P_ID int,
    P_ADD VARCHAR(20),
    P_NAME VARCHAR(40),
    P_DIAGNOSIS VARCHAR(50),
    DISCHARGE_DATE Date,
	R_ID int,	
	DEP_ID int,
    PRIMARY KEY (P_ID),
	-- FOREIGN KEY (R_ID) REFERENCES Record(R_ID)
    FOREIGN KEY (DEP_ID) REFERENCES Department(DEP_ID)
 );
ALTER TABLE Patient MODIFY P_NAME VARCHAR(40) NOT NULL;

create table Record (
	R_ID int,
	PROBLEM varchar(50)  NOT NULL,
    DATE_OF_EXAM date,
    P_ID int,
    PRIMARY KEY (R_ID),
	FOREIGN KEY (P_ID) REFERENCES Patient(P_ID)
);

create table Doctor (
	DOC_ID int,
	DOC_NAME varchar(20) NOT NULL,
    QUAL VARCHAR(10),
    SALARY int,
    DEP_ID int NOT NULL,
    PRIMARY KEY (DOC_ID),
    FOREIGN KEY (DEP_ID) REFERENCES Department(DEP_ID)
);
-- ALTER TABLE Doctor MODIFY QUAL VARCHAR(10);
-- TABLE INPUT COMMANDS -- 

SET foreign_key_checks = 0;

INSERT INTO Doctor VALUES(1,'Ankit','MBBS',242434,1);
INSERT INTO Doctor VALUES(2,'Siddharth','MS',45444,2);
INSERT INTO Doctor VALUES(3,'Pratik','MD',245745,2);
INSERT INTO Doctor VALUES(4,'Amit','MBBS',29555,3);
INSERT INTO Doctor VALUES(5,'Sumit','MD',59555,4);

-- ALTER TABLE Department DROP FOREIGN KEY P_ID;
-- ALTER TABLE Department DROP COLUMN P_ID ;
 
INSERT INTO Department VALUES(1,'ENT');
INSERT INTO Department VALUES(2,'GENERAL');
INSERT INTO Department VALUES(3,'ORTHO');
INSERT INTO Department VALUES(4,'GASTRO');

INSERT INTO Patient VALUES(1,'New Delhi', 'abc', 'afdfd g hthg', 1,1, '2020-05-07');
INSERT INTO Patient VALUES(2,'OLD Delhi', 'abx', 'Allergies & Asthma.', 2,1, '2019-12-12');
INSERT INTO Patient VALUES(3,'Lucknow', 'rgth', 'Crohs & Colitis.', 3,3, '2019-12-13');
INSERT INTO Patient VALUES(4,'Kanpur', 'bfbg', 'Infectious Diseases', 4,2, '2019-12-15');
INSERT INTO Patient VALUES(5,'New Delhi', 'abc', 'bone infection', 5,3, '2019-12-15');
INSERT INTO Patient VALUES(6,'New Delhi', 'man', 'lung infection', 6,2, '2019-12-16');
INSERT INTO Patient VALUES(7,'Indore', 'kkkk', 'Stomach infection', 7,4, '2019-12-16');
INSERT INTO Patient VALUES(8,'New Delhi', 'abc', 'Myiopia', 1,1, '2020-12-16');

INSERT INTO Record VALUES(1, 'afdfd g hthg ','2020-05-04', 1);
INSERT INTO Record VALUES(2,'Allergies & Asthma.', '2019-12-6',2);
INSERT INTO Record VALUES(3,'Crohs & Colitis.', '2019-12-7', 3);
INSERT INTO Record VALUES(4,'Infectious Diseases', '2019-12-8', 4);
INSERT INTO Record VALUES(5, 'bone infection', '2019-12-9', 5);
INSERT INTO Record VALUES(6, 'lung infection', '2019-12-10', 6);
INSERT INTO Record VALUES(7, 'Stomach infection', '2019-12-11', 7);
INSERT INTO Record VALUES(8, 'Myopia ','2020-05-04', 1);

-- DROP TABLE department;
-- 
SELECT DOC_NAME,DEP_NAME,P_ID,P_NAME FROM Doctor, Department, Patient 
where Doctor.DEP_ID = Department.DEP_ID and Patient.DEP_ID = Department.DEP_ID; 

 -- TRUNCATE Patient;
-- ALTER TABLE Patient ADD DISCHARGE_DATE Date;

SELECT COUNT(P_NAME),DISCHARGE_DATE from patient where DISCHARGE_DATE BETWEEN '2019-12-12' and '2019-12-19'
GROUP BY DISCHARGE_DATE; 
